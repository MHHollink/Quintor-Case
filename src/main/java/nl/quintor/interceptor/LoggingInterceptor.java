package nl.quintor.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@Log
public class LoggingInterceptor {

    private static final Logger logger = Logger.getLogger("nl.quintor");

    @AroundInvoke
    public Object logMethodEntry(InvocationContext ctx) throws Exception {
        logger.info(ctx.getMethod().getName() + " was called...");
        return ctx.proceed();
    }
}
