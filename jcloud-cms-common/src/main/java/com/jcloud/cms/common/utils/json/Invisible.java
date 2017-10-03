/**
* Copyright(c) 2002-2013, 360buy.com  All Rights Reserved
*/

package com.jcloud.cms.common.utils.json;

import java.lang.annotation.*;

/**
 * @author wangx
 * @date 2013-7-31
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Invisible {
}

