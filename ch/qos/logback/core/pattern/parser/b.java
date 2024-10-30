/*     */ package ch.qos.logback.core.pattern.parser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class b
/*     */ {
/*     */   static final int dl = 37;
/*     */   static final int dm = 41;
/*     */   static final int MINUS = 45;
/*     */   static final int DOT = 46;
/*     */   static final int dn = 123;
/*     */   static final int do = 125;
/*     */   static final int LITERAL = 1000;
/*     */   static final int dp = 1002;
/*     */   static final int SIMPLE_KEYWORD = 1004;
/*     */   static final int COMPOSITE_KEYWORD = 1005;
/*     */   static final int dq = 1006;
/*     */   static final int EOF = 2147483647;
/*  34 */   static b a = new b(2147483647, "EOF");
/*  35 */   static b b = new b(41);
/*  36 */   static b c = new b(1005, "BARE");
/*  37 */   static b d = new b(37);
/*     */   
/*     */   private final int type;
/*     */   private final Object value;
/*     */   
/*     */   public b(int paramInt) {
/*  43 */     this(paramInt, null);
/*     */   }
/*     */   
/*     */   public b(int paramInt, Object paramObject) {
/*  47 */     this.type = paramInt;
/*  48 */     this.value = paramObject;
/*     */   }
/*     */   
/*     */   public int getType() {
/*  52 */     return this.type;
/*     */   }
/*     */   
/*     */   public Object getValue() {
/*  56 */     return this.value;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  60 */     String str = null;
/*  61 */     switch (this.type) {
/*     */       
/*     */       case 37:
/*  64 */         str = "%";
/*     */         break;
/*     */       case 1002:
/*  67 */         str = "FormatModifier";
/*     */         break;
/*     */       case 1000:
/*  70 */         str = "LITERAL";
/*     */         break;
/*     */       case 1006:
/*  73 */         str = "OPTION";
/*     */         break;
/*     */       case 1004:
/*  76 */         str = "SIMPLE_KEYWORD";
/*     */         break;
/*     */       case 1005:
/*  79 */         str = "COMPOSITE_KEYWORD";
/*     */         break;
/*     */       case 41:
/*  82 */         str = "RIGHT_PARENTHESIS";
/*     */         break;
/*     */       default:
/*  85 */         str = "UNKNOWN"; break;
/*     */     } 
/*  87 */     if (this.value == null) {
/*  88 */       return "Token(" + str + ")";
/*     */     }
/*     */     
/*  91 */     return "Token(" + str + ", \"" + this.value + "\")";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  97 */     int i = this.type;
/*  98 */     i = 29 * i + ((this.value != null) ? this.value.hashCode() : 0);
/*  99 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 103 */     if (this == paramObject)
/* 104 */       return true; 
/* 105 */     if (!(paramObject instanceof b)) {
/* 106 */       return false;
/*     */     }
/* 108 */     b b1 = (b)paramObject;
/*     */     
/* 110 */     if (this.type != b1.type)
/* 111 */       return false; 
/* 112 */     if ((this.value != null) ? !this.value.equals(b1.value) : (b1.value != null)) {
/* 113 */       return false;
/*     */     }
/* 115 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\parser\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */