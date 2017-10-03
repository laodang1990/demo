package com.jcloud.cms.common.utils;
import com.jcloud.cms.common.model.ResponsesDT;
import com.jcloud.cms.common.model.ReturnCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static final Log logger = LogFactory.getLog(DateUtils.class);

    public static ResponsesDT checkDate(Date startTime, Date endTime) {
        return checkDate(startTime, endTime, false, true);
    }

    public static ResponsesDT checkDate(Date startTime, Date endTime, boolean allowStartEqualEnd, boolean allowStartEqualHourNow) {
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.set(Calendar.MINUTE, 0);
        currentCalendar.set(Calendar.SECOND, 0);
        currentCalendar.set(Calendar.MILLISECOND, 0);
        if (!allowStartEqualHourNow) {
            currentCalendar.add(Calendar.HOUR_OF_DAY, 1);
        }

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startTime);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endTime);
        if (startCalendar.before(currentCalendar)) {
            logger.debug("开始时间 " + startCalendar.toString() + " 早于当前时间 " + currentCalendar.toString());
            return new ResponsesDT(ReturnCode.ERROR_DATE_CHECK_START_EARLIER_THAN_NOW);
        }
        Calendar thirtyDaysLaterCalendar = Calendar.getInstance();
        thirtyDaysLaterCalendar.add(Calendar.DAY_OF_MONTH, 30);
        if (startCalendar.after(thirtyDaysLaterCalendar) || endCalendar.after(thirtyDaysLaterCalendar)) {
            logger.debug("时间晚于30天之后");
            logger.debug("开始时间 " + startCalendar.toString() + "， 结束时间 " + endCalendar.toString());
            return new ResponsesDT(ReturnCode.ERROR_DATE_CHECK_THIRTY_DAYS_LATER);
        }
        boolean startLaterThanEnd = allowStartEqualEnd ? startCalendar.after(endCalendar) : !startCalendar.before(endCalendar);
        if (startLaterThanEnd) {
            logger.debug("开始时间 " + startCalendar.toString() + " 晚于结束时间 " + endCalendar.toString());
            return new ResponsesDT(ReturnCode.ERROR_DATE_CHECK_START_LATER_THAN_END);
        }
        return new ResponsesDT(ReturnCode.ACTIVE_SUCCESS);
    }
}
