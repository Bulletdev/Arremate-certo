/*     */ package com.sun.jna;
/*     */ 
/*     */ import com.sun.jna.internal.ReflectionUtils;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
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
/*     */ public interface Library
/*     */ {
/*     */   public static final String OPTION_TYPE_MAPPER = "type-mapper";
/*     */   public static final String OPTION_FUNCTION_MAPPER = "function-mapper";
/*     */   public static final String OPTION_INVOCATION_MAPPER = "invocation-mapper";
/*     */   public static final String OPTION_STRUCTURE_ALIGNMENT = "structure-alignment";
/*     */   public static final String OPTION_STRING_ENCODING = "string-encoding";
/*     */   public static final String OPTION_ALLOW_OBJECTS = "allow-objects";
/*     */   public static final String OPTION_CALLING_CONVENTION = "calling-convention";
/*     */   public static final String OPTION_OPEN_FLAGS = "open-flags";
/*     */   public static final String OPTION_CLASSLOADER = "classloader";
/*     */   
/*     */   public static class Handler
/*     */     implements InvocationHandler
/*     */   {
/*     */     static final Method OBJECT_TOSTRING;
/*     */     static final Method OBJECT_HASHCODE;
/*     */     static final Method OBJECT_EQUALS;
/*     */     private final NativeLibrary nativeLibrary;
/*     */     private final Class<?> interfaceClass;
/*     */     private final Map<String, Object> options;
/*     */     private final InvocationMapper invocationMapper;
/*     */     
/*     */     static {
/*     */       try {
/* 125 */         OBJECT_TOSTRING = Object.class.getMethod("toString", new Class[0]);
/* 126 */         OBJECT_HASHCODE = Object.class.getMethod("hashCode", new Class[0]);
/* 127 */         OBJECT_EQUALS = Object.class.getMethod("equals", new Class[] { Object.class });
/* 128 */       } catch (Exception exception) {
/* 129 */         throw new Error("Error retrieving Object.toString() method");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private static final class FunctionInfo
/*     */     {
/*     */       final InvocationHandler handler;
/*     */       
/*     */       final Function function;
/*     */       
/*     */       final boolean isVarArgs;
/*     */       
/*     */       final Object methodHandle;
/*     */       final Map<String, ?> options;
/*     */       final Class<?>[] parameterTypes;
/*     */       
/*     */       FunctionInfo(Object param2Object) {
/* 147 */         this.handler = null;
/* 148 */         this.function = null;
/* 149 */         this.isVarArgs = false;
/* 150 */         this.options = null;
/* 151 */         this.parameterTypes = null;
/* 152 */         this.methodHandle = param2Object;
/*     */       }
/*     */       
/*     */       FunctionInfo(InvocationHandler param2InvocationHandler, Function param2Function, Class<?>[] param2ArrayOfClass, boolean param2Boolean, Map<String, ?> param2Map) {
/* 156 */         this.handler = param2InvocationHandler;
/* 157 */         this.function = param2Function;
/* 158 */         this.isVarArgs = param2Boolean;
/* 159 */         this.options = param2Map;
/* 160 */         this.parameterTypes = param2ArrayOfClass;
/* 161 */         this.methodHandle = null;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     private final Map<Method, FunctionInfo> functions = new WeakHashMap<Method, FunctionInfo>();
/*     */     
/*     */     public Handler(String param1String, Class<?> param1Class, Map<String, ?> param1Map) {
/* 173 */       if (param1String != null && "".equals(param1String.trim())) {
/* 174 */         throw new IllegalArgumentException("Invalid library name \"" + param1String + "\"");
/*     */       }
/*     */       
/* 177 */       if (!param1Class.isInterface()) {
/* 178 */         throw new IllegalArgumentException(param1String + " does not implement an interface: " + param1Class.getName());
/*     */       }
/*     */       
/* 181 */       this.interfaceClass = param1Class;
/* 182 */       this.options = new HashMap<String, Object>(param1Map);
/* 183 */       boolean bool = AltCallingConvention.class.isAssignableFrom(param1Class) ? true : false;
/*     */ 
/*     */       
/* 186 */       if (this.options.get("calling-convention") == null) {
/* 187 */         this.options.put("calling-convention", Integer.valueOf(bool));
/*     */       }
/* 189 */       if (this.options.get("classloader") == null) {
/* 190 */         this.options.put("classloader", param1Class.getClassLoader());
/*     */       }
/* 192 */       this.nativeLibrary = NativeLibrary.getInstance(param1String, this.options);
/* 193 */       this.invocationMapper = (InvocationMapper)this.options.get("invocation-mapper");
/*     */     }
/*     */     
/*     */     public NativeLibrary getNativeLibrary() {
/* 197 */       return this.nativeLibrary;
/*     */     }
/*     */     
/*     */     public String getLibraryName() {
/* 201 */       return this.nativeLibrary.getName();
/*     */     }
/*     */     
/*     */     public Class<?> getInterfaceClass() {
/* 205 */       return this.interfaceClass;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
/* 213 */       if (OBJECT_TOSTRING.equals(param1Method))
/* 214 */         return "Proxy interface to " + this.nativeLibrary; 
/* 215 */       if (OBJECT_HASHCODE.equals(param1Method))
/* 216 */         return Integer.valueOf(hashCode()); 
/* 217 */       if (OBJECT_EQUALS.equals(param1Method)) {
/* 218 */         Object object = param1ArrayOfObject[0];
/* 219 */         if (object != null && Proxy.isProxyClass(object.getClass())) {
/* 220 */           return Function.valueOf((Proxy.getInvocationHandler(object) == this));
/*     */         }
/* 222 */         return Boolean.FALSE;
/*     */       } 
/*     */ 
/*     */       
/* 226 */       FunctionInfo functionInfo = this.functions.get(param1Method);
/* 227 */       if (functionInfo == null) {
/* 228 */         synchronized (this.functions) {
/* 229 */           functionInfo = this.functions.get(param1Method);
/* 230 */           if (functionInfo == null) {
/* 231 */             boolean bool = ReflectionUtils.isDefault(param1Method);
/* 232 */             if (!bool) {
/* 233 */               boolean bool1 = Function.isVarArgs(param1Method);
/* 234 */               InvocationHandler invocationHandler = null;
/* 235 */               if (this.invocationMapper != null) {
/* 236 */                 invocationHandler = this.invocationMapper.getInvocationHandler(this.nativeLibrary, param1Method);
/*     */               }
/* 238 */               Function function = null;
/* 239 */               Class[] arrayOfClass = null;
/* 240 */               HashMap<String, Object> hashMap = null;
/* 241 */               if (invocationHandler == null) {
/*     */                 
/* 243 */                 function = this.nativeLibrary.getFunction(param1Method.getName(), param1Method);
/* 244 */                 arrayOfClass = param1Method.getParameterTypes();
/* 245 */                 hashMap = new HashMap<String, Object>(this.options);
/* 246 */                 hashMap.put("invoking-method", param1Method);
/*     */               } 
/* 248 */               functionInfo = new FunctionInfo(invocationHandler, function, arrayOfClass, bool1, hashMap);
/*     */             } else {
/* 250 */               functionInfo = new FunctionInfo(ReflectionUtils.getMethodHandle(param1Method));
/*     */             } 
/* 252 */             this.functions.put(param1Method, functionInfo);
/*     */           } 
/*     */         } 
/*     */       }
/* 256 */       if (functionInfo.methodHandle != null) {
/* 257 */         return ReflectionUtils.invokeDefaultMethod(param1Object, functionInfo.methodHandle, param1ArrayOfObject);
/*     */       }
/* 259 */       if (functionInfo.isVarArgs) {
/* 260 */         param1ArrayOfObject = Function.concatenateVarArgs(param1ArrayOfObject);
/*     */       }
/* 262 */       if (functionInfo.handler != null) {
/* 263 */         return functionInfo.handler.invoke(param1Object, param1Method, param1ArrayOfObject);
/*     */       }
/* 265 */       return functionInfo.function.invoke(param1Method, functionInfo.parameterTypes, param1Method.getReturnType(), param1ArrayOfObject, functionInfo.options);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\Library.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */