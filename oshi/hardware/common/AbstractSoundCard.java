/*    */ package oshi.hardware.common;
/*    */ 
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.SoundCard;
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
/*    */ @Immutable
/*    */ public abstract class AbstractSoundCard
/*    */   implements SoundCard
/*    */ {
/*    */   private String kernelVersion;
/*    */   private String name;
/*    */   private String codec;
/*    */   
/*    */   protected AbstractSoundCard(String paramString1, String paramString2, String paramString3) {
/* 50 */     this.kernelVersion = paramString1;
/* 51 */     this.name = paramString2;
/* 52 */     this.codec = paramString3;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDriverVersion() {
/* 57 */     return this.kernelVersion;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 62 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCodec() {
/* 67 */     return this.codec;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder stringBuilder = new StringBuilder();
/* 73 */     stringBuilder.append("SoundCard@");
/* 74 */     stringBuilder.append(Integer.toHexString(hashCode()));
/* 75 */     stringBuilder.append(" [name=");
/* 76 */     stringBuilder.append(this.name);
/* 77 */     stringBuilder.append(", kernelVersion=");
/* 78 */     stringBuilder.append(this.kernelVersion);
/* 79 */     stringBuilder.append(", codec=");
/* 80 */     stringBuilder.append(this.codec);
/* 81 */     stringBuilder.append(']');
/* 82 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractSoundCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */