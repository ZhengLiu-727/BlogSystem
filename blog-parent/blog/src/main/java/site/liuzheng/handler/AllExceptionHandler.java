package site.liuzheng.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import site.liuzheng.vo.Result;

/**
 * 对加了@Controller注解的方法进行拦截处理 AOP
 * @author liuzheng
 */

@ControllerAdvice
public class AllExceptionHandler {

    /**
     * 进行异常处理，返回json数据
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception e) {
        e.printStackTrace();
        return Result.fail(-999, "系统异常");
    }
}
