/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.sql.Connection;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObjectBase;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.SourceCompiler;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueArray;
/*     */ import org.h2.value.ValueNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FunctionAlias
/*     */   extends SchemaObjectBase
/*     */ {
/*     */   private String className;
/*     */   private String methodName;
/*     */   private String source;
/*     */   private JavaMethod[] javaMethods;
/*     */   private boolean deterministic;
/*     */   private boolean bufferResultSetToLocalTemp = true;
/*     */   
/*     */   private FunctionAlias(Schema paramSchema, int paramInt, String paramString) {
/*  51 */     initSchemaObjectBase(paramSchema, paramInt, paramString, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FunctionAlias newInstance(Schema paramSchema, int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
/*  68 */     FunctionAlias functionAlias = new FunctionAlias(paramSchema, paramInt, paramString1);
/*  69 */     int i = paramString2.indexOf('(');
/*  70 */     int j = paramString2.lastIndexOf('.', (i < 0) ? paramString2.length() : i);
/*     */     
/*  72 */     if (j < 0) {
/*  73 */       throw DbException.get(42000, paramString2);
/*     */     }
/*  75 */     functionAlias.className = paramString2.substring(0, j);
/*  76 */     functionAlias.methodName = paramString2.substring(j + 1);
/*  77 */     functionAlias.bufferResultSetToLocalTemp = paramBoolean2;
/*  78 */     functionAlias.init(paramBoolean1);
/*  79 */     return functionAlias;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FunctionAlias newInstanceFromSource(Schema paramSchema, int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
/*  96 */     FunctionAlias functionAlias = new FunctionAlias(paramSchema, paramInt, paramString1);
/*  97 */     functionAlias.source = paramString2;
/*  98 */     functionAlias.bufferResultSetToLocalTemp = paramBoolean2;
/*  99 */     functionAlias.init(paramBoolean1);
/* 100 */     return functionAlias;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void init(boolean paramBoolean) {
/*     */     try {
/* 107 */       load();
/* 108 */     } catch (DbException dbException) {
/* 109 */       if (!paramBoolean) {
/* 110 */         throw dbException;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private synchronized void load() {
/* 116 */     if (this.javaMethods != null) {
/*     */       return;
/*     */     }
/* 119 */     if (this.source != null) {
/* 120 */       loadFromSource();
/*     */     } else {
/* 122 */       loadClass();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void loadFromSource() {
/* 127 */     SourceCompiler sourceCompiler = this.database.getCompiler();
/* 128 */     synchronized (sourceCompiler) {
/* 129 */       String str = "org.h2.dynamic." + getName();
/* 130 */       sourceCompiler.setSource(str, this.source);
/*     */       try {
/* 132 */         Method method = sourceCompiler.getMethod(str);
/* 133 */         JavaMethod javaMethod = new JavaMethod(method, 0);
/* 134 */         this.javaMethods = new JavaMethod[] { javaMethod };
/*     */       
/*     */       }
/* 137 */       catch (DbException dbException) {
/* 138 */         throw dbException;
/* 139 */       } catch (Exception exception) {
/* 140 */         throw DbException.get(42000, exception, new String[] { this.source });
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void loadClass() {
/* 146 */     Class clazz = JdbcUtils.loadUserClass(this.className);
/* 147 */     Method[] arrayOfMethod = clazz.getMethods();
/* 148 */     ArrayList<JavaMethod> arrayList = New.arrayList(); byte b; int i;
/* 149 */     for (b = 0, i = arrayOfMethod.length; b < i; b++) {
/* 150 */       Method method = arrayOfMethod[b];
/* 151 */       if (Modifier.isStatic(method.getModifiers()))
/*     */       {
/*     */         
/* 154 */         if (method.getName().equals(this.methodName) || getMethodSignature(method).equals(this.methodName)) {
/*     */           
/* 156 */           JavaMethod javaMethod = new JavaMethod(method, b);
/* 157 */           for (JavaMethod javaMethod1 : arrayList) {
/* 158 */             if (javaMethod1.getParameterCount() == javaMethod.getParameterCount()) {
/* 159 */               throw DbException.get(90073, new String[] { javaMethod1.toString(), javaMethod.toString() });
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 164 */           arrayList.add(javaMethod);
/*     */         }  } 
/*     */     } 
/* 167 */     if (arrayList.size() == 0) {
/* 168 */       throw DbException.get(90139, this.methodName + " (" + this.className + ")");
/*     */     }
/*     */ 
/*     */     
/* 172 */     this.javaMethods = new JavaMethod[arrayList.size()];
/* 173 */     arrayList.toArray(this.javaMethods);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     Arrays.sort((Object[])this.javaMethods);
/*     */   }
/*     */   
/*     */   private static String getMethodSignature(Method paramMethod) {
/* 182 */     StatementBuilder statementBuilder = new StatementBuilder(paramMethod.getName());
/* 183 */     statementBuilder.append('(');
/* 184 */     for (Class<?> clazz : paramMethod.getParameterTypes()) {
/*     */ 
/*     */       
/* 187 */       statementBuilder.appendExceptFirst(",");
/* 188 */       if (clazz.isArray()) {
/* 189 */         statementBuilder.append(clazz.getComponentType().getName()).append("[]");
/*     */       } else {
/* 191 */         statementBuilder.append(clazz.getName());
/*     */       } 
/*     */     } 
/* 194 */     return statementBuilder.append(')').toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 199 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/* 204 */     return "DROP ALIAS IF EXISTS " + getSQL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 210 */     if ((this.database.getSettings()).functionsInSchema || !getSchema().getName().equals("PUBLIC"))
/*     */     {
/* 212 */       return super.getSQL();
/*     */     }
/* 214 */     return Parser.quoteIdentifier(getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 219 */     StringBuilder stringBuilder = new StringBuilder("CREATE FORCE ALIAS ");
/* 220 */     stringBuilder.append(getSQL());
/* 221 */     if (this.deterministic) {
/* 222 */       stringBuilder.append(" DETERMINISTIC");
/*     */     }
/* 224 */     if (!this.bufferResultSetToLocalTemp) {
/* 225 */       stringBuilder.append(" NOBUFFER");
/*     */     }
/* 227 */     if (this.source != null) {
/* 228 */       stringBuilder.append(" AS ").append(StringUtils.quoteStringSQL(this.source));
/*     */     } else {
/* 230 */       stringBuilder.append(" FOR ").append(Parser.quoteIdentifier(this.className + "." + this.methodName));
/*     */     } 
/*     */     
/* 233 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 238 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void removeChildrenAndResources(Session paramSession) {
/* 243 */     this.database.removeMeta(paramSession, getId());
/* 244 */     this.className = null;
/* 245 */     this.methodName = null;
/* 246 */     this.javaMethods = null;
/* 247 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/* 252 */     throw DbException.getUnsupportedException("RENAME");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JavaMethod findJavaMethod(Expression[] paramArrayOfExpression) {
/* 263 */     load();
/* 264 */     int i = paramArrayOfExpression.length;
/* 265 */     for (JavaMethod javaMethod : this.javaMethods) {
/* 266 */       int j = javaMethod.getParameterCount();
/* 267 */       if (j == i || (javaMethod.isVarArgs() && j <= i + 1))
/*     */       {
/* 269 */         return javaMethod;
/*     */       }
/*     */     } 
/* 272 */     throw DbException.get(90087, getName() + " (" + this.className + ", parameter count: " + i + ")");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getJavaClassName() {
/* 277 */     return this.className;
/*     */   }
/*     */   
/*     */   public String getJavaMethodName() {
/* 281 */     return this.methodName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JavaMethod[] getJavaMethods() {
/* 290 */     load();
/* 291 */     return this.javaMethods;
/*     */   }
/*     */   
/*     */   public void setDeterministic(boolean paramBoolean) {
/* 295 */     this.deterministic = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isDeterministic() {
/* 299 */     return this.deterministic;
/*     */   }
/*     */   
/*     */   public String getSource() {
/* 303 */     return this.source;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isVarArgs(Method paramMethod) {
/* 317 */     if ("1.5".compareTo(SysProperties.JAVA_SPECIFICATION_VERSION) > 0) {
/* 318 */       return false;
/*     */     }
/*     */     try {
/* 321 */       Method method = paramMethod.getClass().getMethod("isVarArgs", new Class[0]);
/* 322 */       Boolean bool = (Boolean)method.invoke(paramMethod, new Object[0]);
/* 323 */       return bool.booleanValue();
/* 324 */     } catch (Exception exception) {
/* 325 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBufferResultSetToLocalTemp() {
/* 335 */     return this.bufferResultSetToLocalTemp;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class JavaMethod
/*     */     implements Comparable<JavaMethod>
/*     */   {
/*     */     private final int id;
/*     */     
/*     */     private final Method method;
/*     */     
/*     */     private final int dataType;
/*     */     private boolean hasConnectionParam;
/*     */     private boolean varArgs;
/*     */     private Class<?> varArgClass;
/*     */     private int paramCount;
/*     */     
/*     */     JavaMethod(Method param1Method, int param1Int) {
/* 353 */       this.method = param1Method;
/* 354 */       this.id = param1Int;
/* 355 */       Class[] arrayOfClass = param1Method.getParameterTypes();
/* 356 */       this.paramCount = arrayOfClass.length;
/* 357 */       if (this.paramCount > 0) {
/* 358 */         Class<?> clazz1 = arrayOfClass[0];
/* 359 */         if (Connection.class.isAssignableFrom(clazz1)) {
/* 360 */           this.hasConnectionParam = true;
/* 361 */           this.paramCount--;
/*     */         } 
/*     */       } 
/* 364 */       if (this.paramCount > 0) {
/* 365 */         Class clazz1 = arrayOfClass[arrayOfClass.length - 1];
/* 366 */         if (clazz1.isArray() && FunctionAlias.isVarArgs(param1Method)) {
/* 367 */           this.varArgs = true;
/* 368 */           this.varArgClass = clazz1.getComponentType();
/*     */         } 
/*     */       } 
/* 371 */       Class<?> clazz = param1Method.getReturnType();
/* 372 */       this.dataType = DataType.getTypeFromClass(clazz);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 377 */       return this.method.toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasConnectionParam() {
/* 386 */       return this.hasConnectionParam;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Value getValue(Session param1Session, Expression[] param1ArrayOfExpression, boolean param1Boolean) {
/*     */       Value value;
/*     */       boolean bool2;
/* 400 */       Class[] arrayOfClass = this.method.getParameterTypes();
/* 401 */       Object[] arrayOfObject = new Object[arrayOfClass.length];
/* 402 */       byte b1 = 0;
/* 403 */       if (this.hasConnectionParam && arrayOfObject.length > 0) {
/* 404 */         arrayOfObject[b1++] = param1Session.createConnection(param1Boolean);
/*     */       }
/*     */ 
/*     */       
/* 408 */       Object object = null;
/* 409 */       if (this.varArgs) {
/* 410 */         int j = param1ArrayOfExpression.length - arrayOfObject.length + 1 + (this.hasConnectionParam ? 1 : 0);
/*     */         
/* 412 */         object = Array.newInstance(this.varArgClass, j);
/* 413 */         arrayOfObject[arrayOfObject.length - 1] = object;
/*     */       }  byte b2;
/*     */       int i;
/* 416 */       for (b2 = 0, i = param1ArrayOfExpression.length; b2 < i; b2++, b1++) {
/* 417 */         Class<?> clazz; Object object1; boolean bool = (this.varArgs && b1 >= arrayOfClass.length - 1) ? true : false;
/*     */ 
/*     */         
/* 420 */         if (bool) {
/* 421 */           clazz = this.varArgClass;
/*     */         } else {
/* 423 */           clazz = arrayOfClass[b1];
/*     */         } 
/* 425 */         int j = DataType.getTypeFromClass(clazz);
/* 426 */         Value value1 = param1ArrayOfExpression[b2].getValue(param1Session);
/*     */         
/* 428 */         if (Value.class.isAssignableFrom(clazz)) {
/* 429 */           object1 = value1;
/* 430 */         } else if (value1.getType() == 17 && clazz.isArray() && clazz.getComponentType() != Object.class) {
/*     */ 
/*     */           
/* 433 */           Value[] arrayOfValue = ((ValueArray)value1).getList();
/* 434 */           Object[] arrayOfObject1 = (Object[])Array.newInstance(clazz.getComponentType(), arrayOfValue.length);
/*     */           
/* 436 */           int k = DataType.getTypeFromClass(clazz.getComponentType());
/*     */           
/* 438 */           for (byte b = 0; b < arrayOfObject1.length; b++) {
/* 439 */             arrayOfObject1[b] = arrayOfValue[b].convertTo(k).getObject();
/*     */           }
/* 441 */           object1 = arrayOfObject1;
/*     */         } else {
/* 443 */           value1 = value1.convertTo(j);
/* 444 */           object1 = value1.getObject();
/*     */         } 
/* 446 */         if (object1 == null) {
/* 447 */           if (clazz.isPrimitive()) {
/* 448 */             if (param1Boolean) {
/*     */ 
/*     */ 
/*     */               
/* 452 */               object1 = DataType.getDefaultForPrimitiveType(clazz);
/*     */             } else {
/*     */               
/* 455 */               return (Value)ValueNull.INSTANCE;
/*     */             }
/*     */           
/*     */           }
/* 459 */         } else if (!clazz.isAssignableFrom(object1.getClass()) && !clazz.isPrimitive()) {
/* 460 */           object1 = DataType.convertTo(param1Session.createConnection(false), value1, clazz);
/*     */         } 
/*     */         
/* 463 */         if (bool) {
/* 464 */           Array.set(object, b1 - arrayOfObject.length + 1, object1);
/*     */         } else {
/* 466 */           arrayOfObject[b1] = object1;
/*     */         } 
/*     */       } 
/* 469 */       boolean bool1 = param1Session.getAutoCommit();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<?>[] getColumnClasses() {
/* 512 */       return this.method.getParameterTypes();
/*     */     }
/*     */     
/*     */     public int getDataType() {
/* 516 */       return this.dataType;
/*     */     }
/*     */     
/*     */     public int getParameterCount() {
/* 520 */       return this.paramCount;
/*     */     }
/*     */     
/*     */     public boolean isVarArgs() {
/* 524 */       return this.varArgs;
/*     */     }
/*     */ 
/*     */     
/*     */     public int compareTo(JavaMethod param1JavaMethod) {
/* 529 */       if (this.varArgs != param1JavaMethod.varArgs) {
/* 530 */         return this.varArgs ? 1 : -1;
/*     */       }
/* 532 */       if (this.paramCount != param1JavaMethod.paramCount) {
/* 533 */         return this.paramCount - param1JavaMethod.paramCount;
/*     */       }
/* 535 */       if (this.hasConnectionParam != param1JavaMethod.hasConnectionParam) {
/* 536 */         return this.hasConnectionParam ? 1 : -1;
/*     */       }
/* 538 */       return this.id - param1JavaMethod.id;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\FunctionAlias.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */