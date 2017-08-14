package sherlock.holmes;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice{
	
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		logger.log(Level.INFO,"method starts..." + arg0); 
	}

}
