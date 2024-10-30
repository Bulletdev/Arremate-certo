/*     */ package org.apache.commons.codec.language.bm;
/*     */ 
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ import org.apache.commons.codec.StringEncoder;
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
/*     */ public class BeiderMorseEncoder
/*     */   implements StringEncoder
/*     */ {
/*  83 */   private PhoneticEngine engine = new PhoneticEngine(NameType.GENERIC, RuleType.APPROX, true);
/*     */ 
/*     */   
/*     */   public Object encode(Object paramObject) throws EncoderException {
/*  87 */     if (!(paramObject instanceof String)) {
/*  88 */       throw new EncoderException("BeiderMorseEncoder encode parameter is not of type String");
/*     */     }
/*  90 */     return encode((String)paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public String encode(String paramString) throws EncoderException {
/*  95 */     if (paramString == null) {
/*  96 */       return null;
/*     */     }
/*  98 */     return this.engine.encode(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameType getNameType() {
/* 107 */     return this.engine.getNameType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RuleType getRuleType() {
/* 116 */     return this.engine.getRuleType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConcat() {
/* 125 */     return this.engine.isConcat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConcat(boolean paramBoolean) {
/* 136 */     this
/*     */ 
/*     */       
/* 139 */       .engine = new PhoneticEngine(this.engine.getNameType(), this.engine.getRuleType(), paramBoolean, this.engine.getMaxPhonemes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNameType(NameType paramNameType) {
/* 150 */     this
/*     */ 
/*     */       
/* 153 */       .engine = new PhoneticEngine(paramNameType, this.engine.getRuleType(), this.engine.isConcat(), this.engine.getMaxPhonemes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRuleType(RuleType paramRuleType) {
/* 163 */     this
/*     */ 
/*     */       
/* 166 */       .engine = new PhoneticEngine(this.engine.getNameType(), paramRuleType, this.engine.isConcat(), this.engine.getMaxPhonemes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxPhonemes(int paramInt) {
/* 177 */     this
/*     */       
/* 179 */       .engine = new PhoneticEngine(this.engine.getNameType(), this.engine.getRuleType(), this.engine.isConcat(), paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\bm\BeiderMorseEncoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */