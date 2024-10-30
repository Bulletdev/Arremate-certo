/*     */ package br.com.arremate.j.l.a;
/*     */ 
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Random;
/*     */ import org.apache.http.NameValuePair;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   extends i
/*     */ {
/*  24 */   static final String DOMAIN = "simulador-comprasnet/";
/*     */   private List<a> v;
/*     */   
/*     */   public d(br.com.arremate.l.d paramd) {
/*  28 */     a(paramd);
/*  29 */     cj();
/*     */   }
/*     */   
/*     */   private void cj() {
/*  33 */     b b = new b(a());
/*     */     
/*  35 */     this.v = new ArrayList<>();
/*  36 */     this.v.add(b.a(100001));
/*  37 */     this.v.add(b.a(100002));
/*  38 */     this.v.add(b.a(100003));
/*  39 */     this.v.add(b.a(100004));
/*  40 */     this.v.add(b.a(100005));
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*  45 */     setRunning(true);
/*  46 */     D("12.345.678/0001-99");
/*  47 */     E("EFFECTI");
/*  48 */     return 1;
/*     */   }
/*     */   
/*     */   public String aR() {
/*  52 */     return "";
/*     */   }
/*     */   
/*     */   public String l(int paramInt) {
/*  56 */     return "";
/*     */   }
/*     */   
/*     */   public String aS() {
/*  60 */     return "";
/*     */   }
/*     */   
/*     */   public String a(int paramInt1, String paramString1, int paramInt2, String paramString2) {
/*  64 */     return "";
/*     */   }
/*     */   
/*     */   public String M(String paramString) {
/*  68 */     return "";
/*     */   }
/*     */   
/*     */   public String m(int paramInt) {
/*  72 */     return "";
/*     */   }
/*     */   
/*     */   public e d() {
/*  76 */     e e = new e(1029L, 200);
/*  77 */     String str = y.ac(DOMAIN + "consultaPregoesLances.html");
/*  78 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  80 */     this.v.forEach(parama -> paramStringBuilder.append(parama.aK()));
/*     */ 
/*     */ 
/*     */     
/*  84 */     str = str.replace("##HTML_PREGOES##", stringBuilder.toString());
/*  85 */     e.setData(str);
/*  86 */     return e;
/*     */   }
/*     */   
/*     */   public e c() {
/*  90 */     e e = new e(1029L, 200);
/*  91 */     String str = y.ac(DOMAIN + "consultaPregoesAgendados.html");
/*     */     
/*  93 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  95 */     this.v.forEach(parama -> paramStringBuilder.append(parama.aL()));
/*     */ 
/*     */ 
/*     */     
/*  99 */     str = str.replace("##HTML_PREGOES##", stringBuilder.toString());
/* 100 */     e.setData(str);
/* 101 */     return e;
/*     */   }
/*     */   
/*     */   public String d(int paramInt) {
/* 105 */     e e = new e(894L, 200);
/* 106 */     String str = y.ac(DOMAIN + "consultaProposta.html");
/* 107 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 109 */     for (byte b = 0; b < this.v.size(); b++) {
/* 110 */       if (((a)this.v.get(b)).getCode() == paramInt) {
/* 111 */         this.v.remove(b);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 116 */     this.v.add((new b(a())).a(paramInt));
/*     */     
/* 118 */     ((a)this.v.stream()
/* 119 */       .filter(parama -> (parama.getCode() == paramInt))
/* 120 */       .findFirst()
/* 121 */       .get())
/* 122 */       .w()
/* 123 */       .forEach(paramc -> paramStringBuilder.append(paramc.aO()));
/*     */ 
/*     */ 
/*     */     
/* 127 */     str = str.replace("##HTML_ITENS##", stringBuilder.toString());
/* 128 */     e.setData(str);
/*     */     
/* 130 */     return e.getData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String d(int paramInt, String paramString) {
/* 138 */     a a = this.v.stream().filter(parama -> (parama.getCode() == paramInt)).findFirst().get();
/*     */     
/* 140 */     a.w()
/* 141 */       .stream()
/* 142 */       .filter(paramc -> (paramc.getStartTime() == 0L))
/* 143 */       .forEach(paramc -> paramc.r(System.currentTimeMillis()));
/*     */ 
/*     */ 
/*     */     
/* 147 */     e e = new e(67L, 200);
/* 148 */     String str = y.ac(DOMAIN + "gerenciaLance.html");
/* 149 */     e.setData(str);
/* 150 */     return e.getData();
/*     */   }
/*     */   
/*     */   public e c(int paramInt, String paramString1, String paramString2) {
/* 154 */     int j = (new Random()).nextInt(1500);
/* 155 */     e e = new e(j, 200);
/*     */     
/* 157 */     if (paramString2.equals("C")) {
/* 158 */       return e;
/*     */     }
/*     */     
/* 161 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 163 */     ((a)this.v.stream()
/* 164 */       .filter(parama -> (parama.getCode() == paramInt))
/* 165 */       .findFirst()
/* 166 */       .get())
/* 167 */       .w()
/* 168 */       .forEach(paramc -> paramStringBuilder.append(paramc.build()));
/*     */ 
/*     */ 
/*     */     
/* 172 */     String str = y.ac(DOMAIN + "itens.html");
/* 173 */     str = str.replace("##HTML_ITENS##", stringBuilder.toString());
/* 174 */     e.setData(str);
/* 175 */     return e;
/*     */   }
/*     */   
/*     */   public e a(int paramInt1, String paramString1, int paramInt2, String paramString2) {
/* 179 */     return new e();
/*     */   }
/*     */   
/*     */   public e a(int paramInt1, int paramInt2, String paramString) {
/* 183 */     return new e();
/*     */   }
/*     */   
/*     */   public e e() {
/* 187 */     return new e();
/*     */   }
/*     */   
/*     */   public e f() {
/* 191 */     return new e();
/*     */   }
/*     */   
/*     */   public e g() {
/* 195 */     return new e();
/*     */   }
/*     */   
/*     */   public e w(int paramInt) {
/* 199 */     e e = new e();
/* 200 */     c c = a(paramInt);
/*     */     
/* 202 */     if (c != null) {
/* 203 */       e.setData(c.aP());
/*     */     }
/*     */     
/* 206 */     return e;
/*     */   }
/*     */   
/*     */   private c a(int paramInt) {
/* 210 */     c c = null;
/* 211 */     for (a a : this.v) {
/*     */ 
/*     */ 
/*     */       
/* 215 */       Optional<c> optional = a.w().stream().filter(paramc -> (paramc.getCode() == paramInt)).findFirst();
/*     */       
/* 217 */       if (optional.isPresent()) {
/* 218 */         c = optional.get();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 223 */     return c;
/*     */   }
/*     */   
/*     */   public String d(Object paramObject1, Object paramObject2) {
/* 227 */     return "";
/*     */   }
/*     */   
/*     */   public String a(Object paramObject1, Object paramObject2, Object paramObject3) {
/* 231 */     return "";
/*     */   }
/*     */   
/*     */   public String i(Object paramObject) {
/* 235 */     return "";
/*     */   }
/*     */   
/*     */   public String a(NameValuePair[] paramArrayOfNameValuePair) {
/* 239 */     int j = Integer.parseInt(paramArrayOfNameValuePair[3].getValue());
/*     */     
/* 241 */     c c = a(j);
/*     */     
/* 243 */     if (c != null) {
/* 244 */       String str = paramArrayOfNameValuePair[0].getValue();
/* 245 */       str = y.Q(str);
/* 246 */       double d1 = Double.parseDouble(str);
/* 247 */       return c.a(a().bv(), d1);
/*     */     } 
/*     */     
/* 250 */     return "AtualizarPagina('Item não encontrado');";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 255 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 260 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 265 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\l\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */