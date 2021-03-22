package cn.edu.xmu.mybatisplus.aspect;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Aspect
@Component
@Slf4j
public class MyAspect {


    /**
     * 创建切入点,不用写代码，返回类型为void
     * 匹配UserService方法下的selectUserById
     */
    @Pointcut("execution(* cn.edu.xmu.mybatisplus.service.UserService.selectUserById(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before executing selectUserById(id,age) ...");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after executing selectUserById(id,age) ...");
    }
    @AfterReturning(value = "pointCut()",returning = "message")
    public void afterReturning(JoinPoint joinPoint,String message){
        System.out.println("after executing selectUserById(id,age) , return"+message);
    }
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowingAdvice(JoinPoint joinPoint, NullPointerException e){
        System.out.println("----------- 后置异常通知 -----------");
    }
    //调用了,但会导致原来的功能不生效
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("in executing "+proceedingJoinPoint.getSignature().getName()+" ...");
        Object o = null;
        try {
            o = proceedingJoinPoint.proceed();
            log.info(proceedingJoinPoint.getSignature().getDeclaringType().getName());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;
    }
}
