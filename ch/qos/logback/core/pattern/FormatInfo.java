/*     */ package ch.qos.logback.core.pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormatInfo
/*     */ {
/*  23 */   private int min = Integer.MIN_VALUE;
/*  24 */   private int max = Integer.MAX_VALUE;
/*     */   
/*     */   private boolean leftPad = true;
/*     */   private boolean leftTruncate = true;
/*     */   
/*     */   public FormatInfo() {}
/*     */   
/*     */   public FormatInfo(int paramInt1, int paramInt2) {
/*  32 */     this.min = paramInt1;
/*  33 */     this.max = paramInt2;
/*     */   }
/*     */   
/*     */   public FormatInfo(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/*  37 */     this.min = paramInt1;
/*  38 */     this.max = paramInt2;
/*  39 */     this.leftPad = paramBoolean1;
/*  40 */     this.leftTruncate = paramBoolean2;
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
/*     */   public static FormatInfo valueOf(String paramString) throws IllegalArgumentException {
/*  52 */     if (paramString == null) {
/*  53 */       throw new NullPointerException("Argument cannot be null");
/*     */     }
/*     */     
/*  56 */     FormatInfo formatInfo = new FormatInfo();
/*     */     
/*  58 */     int i = paramString.indexOf('.');
/*  59 */     String str1 = null;
/*  60 */     String str2 = null;
/*  61 */     if (i != -1) {
/*  62 */       str1 = paramString.substring(0, i);
/*  63 */       if (i + 1 == paramString.length()) {
/*  64 */         throw new IllegalArgumentException("Formatting string [" + paramString + "] should not end with '.'");
/*     */       }
/*  66 */       str2 = paramString.substring(i + 1);
/*     */     } else {
/*     */       
/*  69 */       str1 = paramString;
/*     */     } 
/*     */     
/*  72 */     if (str1 != null && str1.length() > 0) {
/*  73 */       int j = Integer.parseInt(str1);
/*  74 */       if (j >= 0) {
/*  75 */         formatInfo.min = j;
/*     */       } else {
/*  77 */         formatInfo.min = -j;
/*  78 */         formatInfo.leftPad = false;
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     if (str2 != null && str2.length() > 0) {
/*  83 */       int j = Integer.parseInt(str2);
/*  84 */       if (j >= 0) {
/*  85 */         formatInfo.max = j;
/*     */       } else {
/*  87 */         formatInfo.max = -j;
/*  88 */         formatInfo.leftTruncate = false;
/*     */       } 
/*     */     } 
/*     */     
/*  92 */     return formatInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLeftPad() {
/*  97 */     return this.leftPad;
/*     */   }
/*     */   
/*     */   public void setLeftPad(boolean paramBoolean) {
/* 101 */     this.leftPad = paramBoolean;
/*     */   }
/*     */   
/*     */   public int getMax() {
/* 105 */     return this.max;
/*     */   }
/*     */   
/*     */   public void setMax(int paramInt) {
/* 109 */     this.max = paramInt;
/*     */   }
/*     */   
/*     */   public int getMin() {
/* 113 */     return this.min;
/*     */   }
/*     */   
/*     */   public void setMin(int paramInt) {
/* 117 */     this.min = paramInt;
/*     */   }
/*     */   
/*     */   public boolean isLeftTruncate() {
/* 121 */     return this.leftTruncate;
/*     */   }
/*     */   
/*     */   public void setLeftTruncate(boolean paramBoolean) {
/* 125 */     this.leftTruncate = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 129 */     if (this == paramObject) {
/* 130 */       return true;
/*     */     }
/* 132 */     if (!(paramObject instanceof FormatInfo)) {
/* 133 */       return false;
/*     */     }
/* 135 */     FormatInfo formatInfo = (FormatInfo)paramObject;
/*     */     
/* 137 */     return (this.min == formatInfo.min && this.max == formatInfo.max && this.leftPad == formatInfo.leftPad && this.leftTruncate == formatInfo.leftTruncate);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 142 */     int i = this.min;
/* 143 */     i = 31 * i + this.max;
/* 144 */     i = 31 * i + (this.leftPad ? 1 : 0);
/* 145 */     i = 31 * i + (this.leftTruncate ? 1 : 0);
/* 146 */     return i;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 150 */     return "FormatInfo(" + this.min + ", " + this.max + ", " + this.leftPad + ", " + this.leftTruncate + ")";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\FormatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */