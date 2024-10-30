/*     */ package ch.qos.logback.core.boolex;
/*     */ 
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.spi.LifeCycle;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.regex.PatternSyntaxException;
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
/*     */ public class Matcher
/*     */   extends ContextAwareBase
/*     */   implements LifeCycle
/*     */ {
/*     */   private String regex;
/*     */   private String name;
/*     */   private boolean caseSensitive = true;
/*     */   private boolean canonEq = false;
/*     */   private boolean unicodeCase = false;
/*     */   private boolean start = false;
/*     */   private Pattern pattern;
/*     */   
/*     */   public String getRegex() {
/*  34 */     return this.regex;
/*     */   }
/*     */   
/*     */   public void setRegex(String paramString) {
/*  38 */     this.regex = paramString;
/*     */   }
/*     */   
/*     */   public void start() {
/*  42 */     if (this.name == null) {
/*  43 */       addError("All Matcher objects must be named");
/*     */       return;
/*     */     } 
/*     */     try {
/*  47 */       int i = 0;
/*  48 */       if (!this.caseSensitive) {
/*  49 */         i |= 0x2;
/*     */       }
/*  51 */       if (this.canonEq) {
/*  52 */         i |= 0x80;
/*     */       }
/*  54 */       if (this.unicodeCase) {
/*  55 */         i |= 0x40;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  60 */       this.pattern = Pattern.compile(this.regex, i);
/*  61 */       this.start = true;
/*  62 */     } catch (PatternSyntaxException patternSyntaxException) {
/*  63 */       addError("Failed to compile regex [" + this.regex + "]", patternSyntaxException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void stop() {
/*  68 */     this.start = false;
/*     */   }
/*     */   
/*     */   public boolean isStarted() {
/*  72 */     return this.start;
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
/*     */   public boolean matches(String paramString) throws EvaluationException {
/*  86 */     if (this.start) {
/*  87 */       java.util.regex.Matcher matcher = this.pattern.matcher(paramString);
/*  88 */       return matcher.find();
/*     */     } 
/*  90 */     throw new EvaluationException("Matcher [" + this.regex + "] not started");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCanonEq() {
/*  95 */     return this.canonEq;
/*     */   }
/*     */   
/*     */   public void setCanonEq(boolean paramBoolean) {
/*  99 */     this.canonEq = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isCaseSensitive() {
/* 103 */     return this.caseSensitive;
/*     */   }
/*     */   
/*     */   public void setCaseSensitive(boolean paramBoolean) {
/* 107 */     this.caseSensitive = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isUnicodeCase() {
/* 111 */     return this.unicodeCase;
/*     */   }
/*     */   
/*     */   public void setUnicodeCase(boolean paramBoolean) {
/* 115 */     this.unicodeCase = paramBoolean;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 119 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String paramString) {
/* 123 */     this.name = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\boolex\Matcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */