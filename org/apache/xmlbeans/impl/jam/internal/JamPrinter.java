/*     */ package org.apache.xmlbeans.impl.jam.internal;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JConstructor;
/*     */ import org.apache.xmlbeans.impl.jam.JElement;
/*     */ import org.apache.xmlbeans.impl.jam.JMethod;
/*     */ import org.apache.xmlbeans.impl.jam.JamClassIterator;
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
/*     */ public class JamPrinter
/*     */ {
/*     */   private static final String INDENT = "  ";
/*     */   
/*     */   public static JamPrinter newInstance() {
/*  41 */     return new JamPrinter();
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
/*     */   public void print(JElement paramJElement, PrintWriter paramPrintWriter) {
/*  53 */     print(paramJElement, 0, paramPrintWriter);
/*     */   }
/*     */   
/*     */   public void print(JamClassIterator paramJamClassIterator, PrintWriter paramPrintWriter) {
/*  57 */     while (paramJamClassIterator.hasNext()) {
/*  58 */       JClass jClass = paramJamClassIterator.nextClass();
/*  59 */       paramPrintWriter.println("------------------------------");
/*  60 */       paramPrintWriter.println(jClass.getQualifiedName());
/*  61 */       paramPrintWriter.println("------------------------------");
/*  62 */       print((JElement)jClass, paramPrintWriter);
/*  63 */       paramPrintWriter.println();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void print(JElement paramJElement, int paramInt, PrintWriter paramPrintWriter) {
/*  71 */     indent(paramInt, paramPrintWriter);
/*  72 */     paramPrintWriter.print("[");
/*  73 */     paramPrintWriter.print(getTypeKey(paramJElement));
/*  74 */     paramPrintWriter.print("] ");
/*  75 */     if (paramJElement instanceof JMethod) {
/*  76 */       paramPrintWriter.print(((JMethod)paramJElement).getReturnType().getFieldDescriptor());
/*  77 */       paramPrintWriter.print(" ");
/*  78 */       paramPrintWriter.println(paramJElement.getSimpleName());
/*     */     } else {
/*  80 */       paramPrintWriter.println(paramJElement.getSimpleName());
/*     */     } 
/*  82 */     paramInt++;
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
/*     */   private void print(JAnnotation[] paramArrayOfJAnnotation, int paramInt, PrintWriter paramPrintWriter) {
/*  98 */     for (byte b = 0; b < paramArrayOfJAnnotation.length; b++) {
/*  99 */       indent(paramInt, paramPrintWriter);
/* 100 */       paramPrintWriter.print("<");
/* 101 */       paramPrintWriter.print(getTypeKey(paramArrayOfJAnnotation[b]));
/* 102 */       paramPrintWriter.print("> ");
/* 103 */       paramPrintWriter.print(paramArrayOfJAnnotation[b].getSimpleName());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void indent(int paramInt, PrintWriter paramPrintWriter) {
/* 108 */     for (byte b = 0; b < paramInt; ) { paramPrintWriter.print("  "); b++; }
/*     */   
/*     */   }
/*     */   private String getTypeKey(Object paramObject) {
/* 112 */     if (paramObject == null) return "[?UNKNOWN!]"; 
/* 113 */     String str = paramObject.getClass().getName();
/* 114 */     int i = str.lastIndexOf(".");
/* 115 */     if (i != -1 && i + 1 < str.length()) {
/* 116 */       str = str.substring(i + 1);
/*     */     }
/* 118 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static JElement[] getChildrenFor(JElement paramJElement) {
/* 125 */     ArrayList arrayList = new ArrayList();
/* 126 */     if (paramJElement instanceof JClass) {
/* 127 */       arrayList.addAll(Arrays.asList(((JClass)paramJElement).getDeclaredFields()));
/* 128 */       arrayList.addAll(Arrays.asList(((JClass)paramJElement).getDeclaredMethods()));
/* 129 */       arrayList.addAll(Arrays.asList(((JClass)paramJElement).getConstructors()));
/* 130 */       arrayList.addAll(Arrays.asList(((JClass)paramJElement).getClasses()));
/* 131 */     } else if (paramJElement instanceof JConstructor) {
/* 132 */       arrayList.addAll(Arrays.asList(((JConstructor)paramJElement).getParameters()));
/* 133 */     } else if (paramJElement instanceof JMethod) {
/* 134 */       arrayList.addAll(Arrays.asList(((JMethod)paramJElement).getParameters()));
/*     */     } 
/* 136 */     JElement[] arrayOfJElement = new JElement[arrayList.size()];
/* 137 */     arrayList.toArray((Object[])arrayOfJElement);
/* 138 */     return arrayOfJElement;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\JamPrinter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */