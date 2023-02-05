package org.dongikjo.security.jwt;

 
import java.lang.reflect.Method;
import java.util.Enumeration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j; 

@Component
@Aspect
@Slf4j
public class LogAopHelper {
 
	@Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public void PostMapping() {
	}
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void GetMapping() {
	}
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
	public void PutMapping() {
	}
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.PatchMapping)")
	public void PatchMapping() {
	}
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
	public void DeleteMapping() {
	} 

	@Pointcut("execution(* com.example.demo.user.controller..*.*(..))")
	private void user() {
	}
	
	@Around("PostMapping()")
	public Object requestPostLog(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
			Enumeration<String> parameterNames = request.getParameterNames();
			log.info("------------------------------------------------------------------------------------------ START.");
			log.info("IP : {}", request.getRemoteAddr());
			log.info("URI : {}", request.getRequestURI());
			log.info("SESSION ID : {}", request.getSession().getId());
			while (parameterNames.hasMoreElements()) {
				String key = parameterNames.nextElement();
				String value = request.getParameter(key);
				log.info("{} : {}", key, value);
			}
			log.info("------------------------------------------------------------------------------------------   END.");
			Object result = joinPoint.proceed();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Before("PostMapping()")
	public void beforePostLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		log.info("------------------------------------------------------------------------------------------ START.");
		log.info("{}.{}()", className, method.getName());

		Object[] args = joinPoint.getArgs();
		if (args.length <= 0)
			log.info("NO PARAMETERS");
		for (Object arg : args) {
			log.info("PRAMETERS : {}", arg);
		}
	}

	@AfterReturning(value = "PostMapping()", returning = "retObj")
	public void afterReturningPostLog(JoinPoint joinPoint, Object retObj) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		log.info("{}.{}()", className, method.getName());
		log.info("RETURN : {}", retObj);
		log.info("------------------------------------------------------------------------------------------   END.");
	}

	@Around("GetMapping()")
	public Object requestGetLog(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
			Enumeration<String> parameterNames = request.getParameterNames();
			log.info("------------------------------------------------------------------------------------------ START.");
			log.info("IP : {}", request.getRemoteAddr());
			log.info("URI : {}", request.getRequestURI());
			log.info("SESSION ID : {}", request.getSession().getId());
			while (parameterNames.hasMoreElements()) {
				String key = parameterNames.nextElement();
				String value = request.getParameter(key);
				log.info("{} : {}", key, value);
			}
			log.info("------------------------------------------------------------------------------------------   END.");
			Object result = joinPoint.proceed();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Before("GetMapping()")
	public void beforeGetLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		log.info("------------------------------------------------------------------------------------------ START.");
		log.info("{}.{}()", className, method.getName());

		Object[] args = joinPoint.getArgs();
		if (args.length <= 0)
			log.info("NO PARAMETERS");
		for (Object arg : args) {
			log.info("PRAMETERS : {}", arg);
		}
	}

	@AfterReturning(value = "GetMapping()", returning = "retObj")
	public void afterReturningGetLog(JoinPoint joinPoint, Object retObj) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		log.info("{}.{}()", className, method.getName());
		log.info("RETURN : {}", retObj);
		log.info("------------------------------------------------------------------------------------------   END.");
	}
	
	@Around("PutMapping()")
	public Object requestPutLog(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
			Enumeration<String> parameterNames = request.getParameterNames();
			log.info("------------------------------------------------------------------------------------------ START.");
			log.info("IP : {}", request.getRemoteAddr());
			log.info("URI : {}", request.getRequestURI());
			log.info("SESSION ID : {}", request.getSession().getId());
			while (parameterNames.hasMoreElements()) {
				String key = parameterNames.nextElement();
				String value = request.getParameter(key);
				log.info("{} : {}", key, value);
			}
			log.info("------------------------------------------------------------------------------------------   END.");
			Object result = joinPoint.proceed();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Before("PutMapping()")
	public void beforePutLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		log.info("------------------------------------------------------------------------------------------ START.");
		log.info("{}.{}()", className, method.getName());

		Object[] args = joinPoint.getArgs();
		if (args.length <= 0)
			log.info("NO PARAMETERS");
		for (Object arg : args) {
			log.info("PRAMETERS : {}", arg);
		}
	}

	@AfterReturning(value = "PutMapping()", returning = "retObj")
	public void afterReturningPutLog(JoinPoint joinPoint, Object retObj) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		log.info("{}.{}()", className, method.getName());
		log.info("RETURN : {}", retObj);
		log.info("------------------------------------------------------------------------------------------   END.");
	}
	
	
	
	@Around("PatchMapping()")
	public Object requestPatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
			Enumeration<String> parameterNames = request.getParameterNames();
			log.info("------------------------------------------------------------------------------------------ START.");
			log.info("IP : {}", request.getRemoteAddr());
			log.info("URI : {}", request.getRequestURI());
			log.info("SESSION ID : {}", request.getSession().getId());
			while (parameterNames.hasMoreElements()) {
				String key = parameterNames.nextElement();
				String value = request.getParameter(key);
				log.info("{} : {}", key, value);
			}
			log.info("------------------------------------------------------------------------------------------   END.");
			Object result = joinPoint.proceed();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Before("PatchMapping()")
	public void beforePatchLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		log.info("------------------------------------------------------------------------------------------ START.");
		log.info("{}.{}()", className, method.getName());

		Object[] args = joinPoint.getArgs();
		if (args.length <= 0)
			log.info("NO PARAMETERS");
		for (Object arg : args) {
			log.info("PRAMETERS : {}", arg);
		}
	}

	@AfterReturning(value = "PatchMapping()", returning = "retObj")
	public void afterReturningPatchLog(JoinPoint joinPoint, Object retObj) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		log.info("{}.{}()", className, method.getName());
		log.info("RETURN : {}", retObj);
		log.info("------------------------------------------------------------------------------------------   END.");
	}
	
	
	
	@Around("DeleteMapping()")
	public Object requestDeleteLog(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
			Enumeration<String> parameterNames = request.getParameterNames();
			log.info("------------------------------------------------------------------------------------------ START.");
			log.info("IP : {}", request.getRemoteAddr());
			log.info("URI : {}", request.getRequestURI());
			log.info("SESSION ID : {}", request.getSession().getId());
			while (parameterNames.hasMoreElements()) {
				String key = parameterNames.nextElement();
				String value = request.getParameter(key);
				log.info("{} : {}", key, value);
			}
			log.info("------------------------------------------------------------------------------------------   END.");
			Object result = joinPoint.proceed();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Before("DeleteMapping()")
	public void beforeDeleteLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		log.info("------------------------------------------------------------------------------------------ START.");
		log.info("{}.{}()", className, method.getName());

		Object[] args = joinPoint.getArgs();
		if (args.length <= 0)
			log.info("NO PARAMETERS");
		for (Object arg : args) {
			log.info("PRAMETERS : {}", arg);
		}
	}

	@AfterReturning(value = "DeleteMapping()", returning = "retObj")
	public void afterReturningDeleteLog(JoinPoint joinPoint, Object retObj) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		log.info("{}.{}()", className, method.getName());
		log.info("RETURN : {}", retObj);
		log.info("------------------------------------------------------------------------------------------   END.");
	}

}
