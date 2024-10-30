/*     */ package repackage;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
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
/*     */ public class a
/*     */ {
/*  28 */   private List bb = new ArrayList();
/*  29 */   private List bc = new ArrayList(); private Matcher[] a;
/*     */   public a(String paramString) {
/*  31 */     ArrayList arrayList = a(paramString, ';');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/*  38 */       b = 0;
/*     */       
/*  40 */       for (byte b1 = 1; b1 < arrayList.size(); b1++) {
/*     */         
/*  42 */         String str1 = arrayList.get(b1 - 1);
/*  43 */         String str2 = arrayList.get(b1);
/*     */         
/*  45 */         if (str1.indexOf(':') < str2.indexOf(':'))
/*     */         {
/*  47 */           arrayList.set(b1 - 1, str2);
/*  48 */           arrayList.set(b1, str1);
/*     */           
/*  50 */           b = 1;
/*     */         }
/*     */       
/*     */       } 
/*  54 */     } while (b);
/*     */ 
/*     */ 
/*     */     
/*  58 */     for (byte b = 0; b < arrayList.size(); b++) {
/*     */       
/*  60 */       String str1 = arrayList.get(b);
/*     */       
/*  62 */       int i = str1.indexOf(':');
/*     */       
/*  64 */       if (i < 0 || str1.indexOf(':', i + 1) >= 0) {
/*  65 */         throw new RuntimeException("Illegal repackage specification: " + str1);
/*     */       }
/*  67 */       String str2 = str1.substring(0, i);
/*  68 */       String str3 = str1.substring(i + 1);
/*     */       
/*  70 */       this.bb.add(a(str2, '.'));
/*  71 */       this.bc.add(a(str3, '.'));
/*     */     } 
/*     */     
/*  74 */     this.a = new Matcher[this.bb.size() * 2];
/*  75 */     this.r = new String[this.bb.size() * 2];
/*     */     
/*  77 */     a('.', 0);
/*  78 */     a('/', this.bb.size());
/*     */   }
/*     */   private String[] r;
/*     */   
/*     */   void a(char paramChar, int paramInt) {
/*  83 */     for (byte b = 0; b < this.bb.size(); b++) {
/*     */       
/*  85 */       List list1 = this.bb.get(b);
/*  86 */       List list2 = this.bc.get(b);
/*     */       
/*  88 */       String str1 = "";
/*     */       
/*  90 */       for (byte b1 = 0; b1 < list1.size(); b1++) {
/*     */         
/*  92 */         if (b1 > 0) {
/*  93 */           str1 = str1 + "\\" + paramChar;
/*     */         }
/*  95 */         str1 = str1 + list1.get(b1);
/*     */       } 
/*     */       
/*  98 */       String str2 = "";
/*     */       
/* 100 */       for (byte b2 = 0; b2 < list2.size(); b2++) {
/*     */         
/* 102 */         if (b2 > 0) {
/* 103 */           str2 = str2 + paramChar;
/*     */         }
/* 105 */         str2 = str2 + list2.get(b2);
/*     */       } 
/*     */       
/* 108 */       this.a[paramInt + b] = Pattern.compile(str1).matcher("");
/* 109 */       this.r[paramInt + b] = str2;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public StringBuffer a(StringBuffer paramStringBuffer) {
/* 115 */     StringBuffer stringBuffer = null;
/*     */     
/* 117 */     for (byte b = 0; b < this.a.length; b++) {
/*     */       
/* 119 */       Matcher matcher = this.a[b];
/*     */       
/* 121 */       matcher.reset(paramStringBuffer);
/*     */       boolean bool;
/* 123 */       for (bool = matcher.find(); bool; bool = matcher.find()) {
/*     */         
/* 125 */         if (stringBuffer == null) {
/* 126 */           stringBuffer = new StringBuffer();
/*     */         }
/* 128 */         matcher.appendReplacement(stringBuffer, this.r[b]);
/*     */       } 
/*     */       
/* 131 */       if (stringBuffer != null) {
/*     */         
/* 133 */         matcher.appendTail(stringBuffer);
/* 134 */         paramStringBuffer = stringBuffer;
/* 135 */         stringBuffer = null;
/*     */       } 
/*     */     } 
/*     */     
/* 139 */     return paramStringBuffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public List bG() {
/* 144 */     return this.bb;
/*     */   }
/*     */ 
/*     */   
/*     */   public List bH() {
/* 149 */     return this.bc;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList a(String paramString, char paramChar) {
/* 154 */     ArrayList arrayList = new ArrayList();
/*     */ 
/*     */     
/*     */     while (true) {
/* 158 */       int i = paramString.indexOf(paramChar);
/*     */       
/* 160 */       if (i < 0) {
/*     */         break;
/*     */       }
/* 163 */       arrayList.add(paramString.substring(0, i));
/*     */       
/* 165 */       paramString = paramString.substring(i + 1);
/*     */     } 
/*     */     
/* 168 */     if (paramString.length() > 0) {
/* 169 */       arrayList.add(paramString);
/*     */     }
/* 171 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String bt(String paramString) {
/* 176 */     return (new File(paramString)).getParent();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\repackage\a.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */