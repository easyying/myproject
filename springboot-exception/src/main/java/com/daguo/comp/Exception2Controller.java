package com.daguo.comp;

import com.daguo.advanced.exception.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * 接受不同的异常类型的处理
 */
@RestController
@Slf4j
public class Exception2Controller {
    @GetMapping("/getResult1")
    public Result throwException1(){
        try {
            System.out.println("进来了");
            throw new BusinessException(ExceptionCodeConstant.REQUEST_VALIDATION_FAILED,"自定义异常报错");
        }catch (BusinessException e){
            return Result.getErrorResult(((BusinessException) e).getCode(),e.getMessage());
      /*  }catch (Business11Exception e){
            return Result.getErrorResult(((BusinessException11) e).getCode(),e.getMessage());*/
        }catch (Exception ex){
            return Result.getErrorResult("500", "系统错误");
        }
    }
    @GetMapping("/getResult2")
    public Result throwException2(){
        Person person;
        try {
            person = new Person(1,"大大");
            throw new BusinessException(ExceptionCodeConstant.REQUEST_VALIDATION_FAILED,"1001");
        }catch (BusinessException e){
            return getResultCommon(e);
      /*  }catch (Business11Exception e){
            return getResultCommon(e);*/
        }catch (Exception ex){
            return getResultCommon(ex);
        }
    }


    //或者统一到一个地方
    public Result getResultCommon(Exception e) {
        if(e instanceof BusinessException){
            return Result.getErrorResult(((BusinessException) e).getCode(), e.getMessage());
        }
      /*  if(e instanceof Business11Exception){
            Business11Exception be = (Business11Exception)e;
            return Result.getErrorResult(be.getError().getErrorCode(),be.getError().getErrorMessage());
        }*/
        return Result.getErrorResult("500", "系统错误");
    }
}
