package com.wrike.qaa;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;


/**
 * Created by Ivan Varivoda 2019-08-24
 */
public class BoolExpressionExecutor {

    private final JexlEngine jexlEngine = new JexlBuilder().create();
    private final JexlContext jexlContext = new MapContext();

    public boolean eval(String expression) throws TestFilterEvaluationException {
        JexlExpression jexlExpression = jexlEngine.createExpression(expression);
        Object result = jexlExpression.evaluate(jexlContext);

        if (result instanceof Boolean) {
            return (boolean) result;
        } else {
            if (result instanceof Long) {
                return (long) result == 1;
            } else {
                throw new TestFilterEvaluationException();
            }
        }
    }

}
