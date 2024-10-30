/*     */ package org.apache.commons.io.serialization;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InvalidClassException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectStreamClass;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class ValidatingObjectInputStream
/*     */   extends ObjectInputStream
/*     */ {
/*  46 */   private final List<ClassNameMatcher> acceptMatchers = new ArrayList<>();
/*  47 */   private final List<ClassNameMatcher> rejectMatchers = new ArrayList<>();
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
/*     */   public ValidatingObjectInputStream(InputStream paramInputStream) throws IOException {
/*  59 */     super(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validateClassName(String paramString) throws InvalidClassException {
/*  68 */     for (ClassNameMatcher classNameMatcher : this.rejectMatchers) {
/*  69 */       if (classNameMatcher.matches(paramString)) {
/*  70 */         invalidClassNameFound(paramString);
/*     */       }
/*     */     } 
/*     */     
/*  74 */     boolean bool = false;
/*  75 */     for (ClassNameMatcher classNameMatcher : this.acceptMatchers) {
/*  76 */       if (classNameMatcher.matches(paramString)) {
/*  77 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/*  81 */     if (!bool) {
/*  82 */       invalidClassNameFound(paramString);
/*     */     }
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
/*     */   protected void invalidClassNameFound(String paramString) throws InvalidClassException {
/*  95 */     throw new InvalidClassException("Class name not accepted: " + paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass) throws IOException, ClassNotFoundException {
/* 100 */     validateClassName(paramObjectStreamClass.getName());
/* 101 */     return super.resolveClass(paramObjectStreamClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidatingObjectInputStream accept(Class<?>... paramVarArgs) {
/* 112 */     for (Class<?> clazz : paramVarArgs) {
/* 113 */       this.acceptMatchers.add(new FullClassNameMatcher(new String[] { clazz.getName() }));
/*     */     } 
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidatingObjectInputStream reject(Class<?>... paramVarArgs) {
/* 126 */     for (Class<?> clazz : paramVarArgs) {
/* 127 */       this.rejectMatchers.add(new FullClassNameMatcher(new String[] { clazz.getName() }));
/*     */     } 
/* 129 */     return this;
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
/*     */   public ValidatingObjectInputStream accept(String... paramVarArgs) {
/* 141 */     for (String str : paramVarArgs) {
/* 142 */       this.acceptMatchers.add(new WildcardClassNameMatcher(str));
/*     */     }
/* 144 */     return this;
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
/*     */   public ValidatingObjectInputStream reject(String... paramVarArgs) {
/* 156 */     for (String str : paramVarArgs) {
/* 157 */       this.rejectMatchers.add(new WildcardClassNameMatcher(str));
/*     */     }
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidatingObjectInputStream accept(Pattern paramPattern) {
/* 170 */     this.acceptMatchers.add(new RegexpClassNameMatcher(paramPattern));
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidatingObjectInputStream reject(Pattern paramPattern) {
/* 182 */     this.rejectMatchers.add(new RegexpClassNameMatcher(paramPattern));
/* 183 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidatingObjectInputStream accept(ClassNameMatcher paramClassNameMatcher) {
/* 194 */     this.acceptMatchers.add(paramClassNameMatcher);
/* 195 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidatingObjectInputStream reject(ClassNameMatcher paramClassNameMatcher) {
/* 206 */     this.rejectMatchers.add(paramClassNameMatcher);
/* 207 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\serialization\ValidatingObjectInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */