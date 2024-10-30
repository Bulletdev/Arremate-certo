/*    */ package org.apache.poi.sl.draw.geom;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExpressionParser
/*    */ {
/* 32 */   private static final Map<String, ExpressionEntry> impls = new HashMap<String, ExpressionEntry>();
/*    */   
/*    */   private static class ExpressionEntry
/*    */   {
/*    */     final Pattern regex;
/*    */     final Constructor<? extends Expression> con;
/*    */     
/*    */     ExpressionEntry(String param1String, Class<? extends Expression> param1Class) throws SecurityException, NoSuchMethodException {
/* 40 */       this.regex = Pattern.compile(param1String);
/* 41 */       this.con = param1Class.getDeclaredConstructor(new Class[] { Matcher.class });
/* 42 */       ExpressionParser.impls.put(ExpressionParser.op(param1String), this);
/*    */     }
/*    */   }
/*    */   
/*    */   static {
/*    */     try {
/* 48 */       new ExpressionEntry("\\*/ +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", (Class)MultiplyDivideExpression.class);
/* 49 */       new ExpressionEntry("\\+- +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)( 0)?", (Class)AddSubtractExpression.class);
/* 50 */       new ExpressionEntry("\\+/ +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", (Class)AddDivideExpression.class);
/* 51 */       new ExpressionEntry("\\?: +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", (Class)IfElseExpression.class);
/* 52 */       new ExpressionEntry("val +([\\-\\w]+)", (Class)LiteralValueExpression.class);
/* 53 */       new ExpressionEntry("abs +([\\-\\w]+)", (Class)AbsExpression.class);
/* 54 */       new ExpressionEntry("sqrt +([\\-\\w]+)", (Class)SqrtExpression.class);
/* 55 */       new ExpressionEntry("max +([\\-\\w]+) +([\\-\\w]+)", (Class)MaxExpression.class);
/* 56 */       new ExpressionEntry("min +([\\-\\w]+) +([\\-\\w]+)", (Class)MinExpression.class);
/* 57 */       new ExpressionEntry("at2 +([\\-\\w]+) +([\\-\\w]+)", (Class)ArcTanExpression.class);
/* 58 */       new ExpressionEntry("sin +([\\-\\w]+) +([\\-\\w]+)", (Class)SinExpression.class);
/* 59 */       new ExpressionEntry("cos +([\\-\\w]+) +([\\-\\w]+)", (Class)CosExpression.class);
/* 60 */       new ExpressionEntry("tan +([\\-\\w]+) +([\\-\\w]+)", (Class)TanExpression.class);
/* 61 */       new ExpressionEntry("cat2 +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", (Class)CosineArcTanExpression.class);
/* 62 */       new ExpressionEntry("sat2 +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", (Class)SinArcTanExpression.class);
/* 63 */       new ExpressionEntry("pin +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", (Class)PinExpression.class);
/* 64 */       new ExpressionEntry("mod +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", (Class)ModExpression.class);
/* 65 */     } catch (Exception exception) {
/* 66 */       throw new RuntimeException(exception);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static String op(String paramString) {
/* 71 */     return (paramString == null || !paramString.contains(" ")) ? "" : paramString.substring(0, paramString.indexOf(" ")).replace("\\", "");
/*    */   }
/*    */ 
/*    */   
/*    */   public static Expression parse(String paramString) {
/* 76 */     ExpressionEntry expressionEntry = impls.get(op(paramString));
/* 77 */     Matcher matcher = (expressionEntry == null) ? null : expressionEntry.regex.matcher(paramString);
/* 78 */     if (matcher == null || !matcher.matches()) {
/* 79 */       throw new RuntimeException("Unsupported formula: " + paramString);
/*    */     }
/*    */     
/*    */     try {
/* 83 */       return expressionEntry.con.newInstance(new Object[] { matcher });
/* 84 */     } catch (Exception exception) {
/* 85 */       throw new RuntimeException("Unsupported formula: " + paramString, exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\ExpressionParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */