package io.github.penn.rest.call;

import java.lang.annotation.*;

/**
 * @author tangzhongping
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GetCall {

    String path() default "";

}
