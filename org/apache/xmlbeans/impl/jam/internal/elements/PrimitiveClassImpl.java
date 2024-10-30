/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
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
/*     */ public final class PrimitiveClassImpl
/*     */   extends BuiltinClassImpl
/*     */ {
/*  33 */   private static final Object[][] PRIMITIVES = new Object[][] { { "int", "I", int.class }, { "long", "J", long.class }, { "boolean", "Z", boolean.class }, { "short", "S", short.class }, { "byte", "B", byte.class }, { "char", "C", char.class }, { "float", "F", float.class }, { "double", "D", double.class } };
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
/*  48 */   private static final Map NAME_TO_FD = new HashMap();
/*  49 */   private static final Map NAME_TO_CLASS = new HashMap(); static {
/*  50 */     for (byte b = 0; b < PRIMITIVES.length; b++) {
/*  51 */       NAME_TO_FD.put(PRIMITIVES[b][0], PRIMITIVES[b][1]);
/*  52 */       NAME_TO_CLASS.put(PRIMITIVES[b][0], PRIMITIVES[b][2]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void mapNameToPrimitive(ElementContext paramElementContext, Map paramMap) {
/*  60 */     for (byte b = 0; b < PRIMITIVES.length; b++) {
/*  61 */       PrimitiveClassImpl primitiveClassImpl = new PrimitiveClassImpl(paramElementContext, (String)PRIMITIVES[b][0]);
/*  62 */       paramMap.put(PRIMITIVES[b][0], primitiveClassImpl);
/*  63 */       paramMap.put(PRIMITIVES[b][1], primitiveClassImpl);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getPrimitiveClassForName(String paramString) {
/*  74 */     return (String)NAME_TO_FD.get(paramString);
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
/*     */   public static boolean isPrimitive(String paramString) {
/* 106 */     return (NAME_TO_FD.get(paramString) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String getFieldDescriptor(String paramString) {
/* 114 */     return (String)NAME_TO_FD.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Class getPrimitiveClass(String paramString) {
/* 124 */     return (Class)NAME_TO_CLASS.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PrimitiveClassImpl(ElementContext paramElementContext, String paramString) {
/* 131 */     super(paramElementContext);
/* 132 */     if (paramString == null) throw new IllegalArgumentException("null name"); 
/* 133 */     if (!NAME_TO_FD.containsKey(paramString)) {
/* 134 */       throw new IllegalArgumentException("Unknown primitive class '" + paramString + "'");
/*     */     }
/*     */     
/* 137 */     reallySetSimpleName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQualifiedName() {
/* 143 */     return getSimpleName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFieldDescriptor() {
/* 149 */     return (String)NAME_TO_FD.get(getSimpleName());
/*     */   }
/*     */   
/*     */   public boolean isAssignableFrom(JClass paramJClass) {
/* 153 */     return (paramJClass.isPrimitiveType() && paramJClass.getSimpleName().equals(getSimpleName()));
/*     */   }
/*     */   public boolean isPrimitiveType() {
/* 156 */     return true;
/*     */   }
/*     */   public Class getPrimitiveClass() {
/* 159 */     return (Class)NAME_TO_CLASS.get(getSimpleName());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\PrimitiveClassImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */