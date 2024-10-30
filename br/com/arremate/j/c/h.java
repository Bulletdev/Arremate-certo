/*     */ package br.com.arremate.j.c;
/*     */ 
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class h
/*     */ {
/*     */   public static final String bu = "CONNECTED";
/*     */   public static final String bv = "MESSAGE";
/*     */   public static final String bw = "ERROR";
/*     */   private final String content;
/*     */   private String type;
/*     */   private String bx;
/*     */   private i i;
/*     */   
/*     */   public h(String paramString) {
/*  19 */     this.content = paramString;
/*  20 */     bT();
/*     */   }
/*     */   
/*     */   public String getContent() {
/*  24 */     return this.content;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  28 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String paramString) {
/*  32 */     this.type = paramString;
/*     */   }
/*     */   
/*     */   public String ag() {
/*  36 */     return this.bx;
/*     */   }
/*     */   
/*     */   public void B(String paramString) {
/*  40 */     this.bx = paramString;
/*     */   }
/*     */   
/*     */   public i m() {
/*  44 */     return this.i;
/*     */   }
/*     */   
/*     */   public void g(i parami) {
/*  48 */     this.i = parami;
/*     */   }
/*     */   
/*     */   private void bT() {
/*  52 */     String[] arrayOfString = this.content.split("\n");
/*  53 */     setType(arrayOfString[0]);
/*  54 */     if (arrayOfString[0].equals("CONNECTED")) {
/*  55 */       B("");
/*  56 */       g((new i())
/*  57 */           .b("connected", true)
/*  58 */           .c("message", (new i()).c("user", r(arrayOfString[3]))));
/*     */     }
/*  60 */     else if (arrayOfString[0].equals("MESSAGE")) {
/*  61 */       i i1 = new i();
/*     */       try {
/*  63 */         String str = arrayOfString[arrayOfString.length - 1];
/*  64 */         str = str.substring(0, str.length() - 1);
/*  65 */         if (str.substring(0, 1).equals("[")) {
/*  66 */           f f = new f(str);
/*     */         } else {
/*     */           
/*  69 */           i1 = new i(str);
/*     */         }
/*     */       
/*  72 */       } catch (Exception exception) {}
/*     */       
/*  74 */       B(a(arrayOfString, "classe"));
/*  75 */       g((new i())
/*  76 */           .b("connected", true)
/*  77 */           .c("message", i1));
/*     */     }
/*  79 */     else if (arrayOfString[0].equals("ERROR")) {
/*  80 */       B("");
/*  81 */       g((new i())
/*  82 */           .b("connected", false)
/*  83 */           .c("message", a(arrayOfString, "message")));
/*     */     } 
/*     */   }
/*     */   
/*     */   private String r(String paramString) {
/*  88 */     return paramString.split(":")[1];
/*     */   }
/*     */   
/*     */   private String a(String[] paramArrayOfString, String paramString) {
/*  92 */     for (String str : paramArrayOfString) {
/*  93 */       if (str.split(":")[0].trim().toLowerCase().equals(paramString.toLowerCase())) {
/*  94 */         return str.split(":")[1].trim();
/*     */       }
/*     */     } 
/*  97 */     return null;
/*     */   }
/*     */   
/*     */   public i n() {
/* 101 */     return (new i())
/* 102 */       .c("type", getType())
/* 103 */       .c("dispatch", ag())
/* 104 */       .c("message", m());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     return (new i())
/* 110 */       .c("type", getType())
/* 111 */       .c("dispatch", ag())
/* 112 */       .c("message", m())
/* 113 */       .toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\c\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */