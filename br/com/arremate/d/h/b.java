/*     */ package br.com.arremate.d.h;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.h.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ public class b extends e {
/*     */   private final SimpleDateFormat b;
/*  25 */   private int Z = 0;
/*  26 */   private m b = null;
/*     */   
/*     */   public b(e parame, a parama) {
/*  29 */     super(parame, (i)parama);
/*  30 */     this.b = (m)new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<m> d() {
/*  36 */     ArrayList<m> arrayList = new ArrayList();
/*  37 */     int i = a().a().v();
/*  38 */     int j = 0;
/*     */     
/*     */     try {
/*  41 */       i i1 = a(i, this.Z);
/*  42 */       if (i1 != null) {
/*  43 */         j = i1.getInt("paginaAtual");
/*  44 */         this.Z = (int)Math.ceil(i1.getInt("quantidadeTotal") / i1.getInt("quantidadePorPagina"));
/*     */         
/*  46 */         if (this.Z == j) {
/*  47 */           a(arrayList, i1);
/*     */         } else {
/*  49 */           for (int k = this.Z; k > 0; k--) {
/*  50 */             i1 = a(i, k);
/*  51 */             if (i1 != null && 
/*  52 */               !a(arrayList, i1)) {
/*     */               break;
/*     */             }
/*     */           }
/*     */         
/*     */         } 
/*     */       } 
/*  59 */     } catch (Exception exception) {
/*  60 */       a.info("Failed to capture message in Compras Publicas {}", Integer.valueOf(i), exception);
/*     */     } 
/*     */     
/*  63 */     if (!arrayList.isEmpty()) {
/*  64 */       this.b = arrayList.get(0);
/*     */     }
/*     */     
/*  67 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean a(ArrayList<m> paramArrayList, i parami) throws ParseException {
/*  71 */     if (parami.has("dadosChat") && !parami.isNull("dadosChat")) {
/*  72 */       f f = parami.c("dadosChat");
/*     */       
/*  74 */       for (int j = f.length() - 1; j >= 0; j--) {
/*  75 */         i i1 = f.b(j);
/*  76 */         String str1 = i1.getString("Apelido");
/*  77 */         Date date = y.a(i1.getString("Data"), i1.getString("Hora"));
/*     */         
/*  79 */         String str2 = i1.getString("Frase");
/*  80 */         if (str2.contains("os autores das ofertas com valores até 10% superiores àquela podem ofertar um lance final e fechado até")) {
/*  81 */           String str = b(str2);
/*  82 */           if (str2.contains("lote")) {
/*  83 */             str = "G" + str;
/*     */           }
/*     */           
/*  86 */           e e1 = a().b(String.valueOf(str));
/*  87 */           if (e1 != null) {
/*  88 */             String str3 = str2.substring(str2.indexOf("fechado até") + 11);
/*  89 */             str3 = str3.replaceAll("\\.", "").replace(" às ", " ").trim();
/*  90 */             Date date1 = this.b.parse(str3);
/*  91 */             long l = date1.getTime() - n.a().longValue();
/*     */             
/*  93 */             if (l < 0L) {
/*  94 */               l = 0L;
/*     */             }
/*     */             
/*  97 */             if (l > e1.z()) {
/*  98 */               e1.x(l);
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 103 */         if (str1.equals("Sistema") && str2.contains("foi encerrado")) {
/* 104 */           String str = b(str2);
/* 105 */           e e1 = a().b(str);
/* 106 */           if (e1 != null && !e1.br()) {
/* 107 */             if (str2.contains("e foram identificadas MEs/EPPs")) {
/* 108 */               e1.N(g.q.getValue());
/*     */             } else {
/* 110 */               e1.N(g.s.getValue());
/*     */             } 
/*     */             
/* 113 */             a().g(e1);
/*     */           } 
/*     */         } 
/*     */         
/* 117 */         m m1 = new m();
/* 118 */         m1.f(str2);
/* 119 */         m1.aE(str1);
/* 120 */         m1.c(date);
/*     */         
/* 122 */         if (this.b != null && this.b.a(m1) >= 0) {
/* 123 */           return false;
/*     */         }
/*     */         
/* 126 */         paramArrayList.add(m1);
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   private i a(int paramInt1, int paramInt2) {
/* 134 */     e e1 = a().g(paramInt1, paramInt2);
/* 135 */     a(e1);
/* 136 */     String str = e1.getData();
/* 137 */     if (!str.isEmpty()) {
/* 138 */       return new i(str);
/*     */     }
/* 140 */     return null;
/*     */   }
/*     */   
/*     */   private void a(e parame) {
/* 144 */     if (parame.O() || parame.getStatusCode() != 200) {
/* 145 */       a().e(parame.k(), parame.getStatusCode());
/*     */     } else {
/* 147 */       a().f(parame.k(), parame.getStatusCode());
/*     */     } 
/*     */   }
/*     */   
/*     */   private String b(String paramString) throws NumberFormatException {
/* 152 */     Pattern pattern = Pattern.compile("\\s\\d+\\s|\\s\\d+[a-zA-Z]\\s|\\s\\d+,\\s|\\s\\d+[a-zA-Z],\\s");
/* 153 */     Matcher matcher = pattern.matcher(paramString);
/* 154 */     if (matcher.find()) {
/* 155 */       paramString = matcher.group().trim();
/* 156 */       String str = paramString.replaceAll("\\d", "").replace(",", "");
/* 157 */       paramString = String.valueOf(Integer.parseInt(paramString.replaceAll("\\D", ""))) + str;
/* 158 */       return paramString;
/*     */     } 
/*     */     
/* 161 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public e a() {
/* 166 */     return (e)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public a a() {
/* 171 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\h\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */