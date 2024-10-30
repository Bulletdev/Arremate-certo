/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.e;
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.k.c;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import org.e.i;
/*     */ 
/*     */ public class m
/*     */   extends a
/*     */ {
/*     */   public m(e parame) {
/*  23 */     super((i)parame);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  28 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public e a() {
/*  33 */     return (e)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) {
/*  38 */     if (paramString.charAt(0) == '/') {
/*  39 */       paramString = paramString.substring(1);
/*     */     }
/*  41 */     String str1 = a().n(paramString).getData();
/*     */     
/*  43 */     if (str1 == null || str1.isEmpty()) {
/*  44 */       return null;
/*     */     }
/*  46 */     i i1 = new i(str1);
/*     */     
/*  48 */     if (!i1.has("procedimento")) {
/*  49 */       return null;
/*     */     }
/*  51 */     i1 = i1.j("procedimento");
/*  52 */     String[] arrayOfString = i1.getString("numeroFormatado").trim().split(" ");
/*  53 */     String str2 = (arrayOfString.length > 1) ? arrayOfString[1] : arrayOfString[0];
/*     */     
/*  55 */     c c = new c(a().a(), Math.abs(Objects.hashCode(paramString)));
/*  56 */     c.aA(paramString);
/*  57 */     c.T(str2);
/*     */     
/*  59 */     i i2 = i1.j("orgaoEntidade");
/*  60 */     c.aw(i2.getString("codigoENome").split("-")[1].trim());
/*  61 */     c.Q(i2.getInt("id"));
/*  62 */     c.a(c(i1.j("situacao").getString("descricao").toLowerCase()));
/*     */     
/*  64 */     c.a(a(i1.getString("tipo")));
/*     */     
/*  66 */     boolean bool = i1.getString("tipo").equals("ProcedimentoPregaoRegistroPrecoEletronico");
/*  67 */     c.s(bool);
/*     */     
/*  69 */     e e = i1.j("modoJulgamento").getString("descricao").toLowerCase().contains("lote") ? e.a : e.b;
/*     */ 
/*     */     
/*  72 */     c.a(e);
/*  73 */     c.a((e == e.b) ? u.a : u.b);
/*  74 */     c.z((bool && e == e.b));
/*  75 */     Optional<i> optional = Optional.ofNullable(i1.c("lotes")
/*  76 */         .b(0)
/*  77 */         .j("definicaoLote")
/*  78 */         .get("modoDisputa"));
/*     */     
/*  80 */     String str3 = "";
/*  81 */     if (optional.isPresent() && 
/*  82 */       optional.get() instanceof i) {
/*  83 */       str3 = ((i)optional.get()).getString("descricao").toLowerCase();
/*     */     }
/*     */ 
/*     */     
/*  87 */     switch (str3) {
/*     */       case "aberto e fechado":
/*  89 */         c.a(br.com.arremate.f.m.c);
/*     */         break;
/*     */       case "aberto":
/*  92 */         c.a(br.com.arremate.f.m.b);
/*     */         break;
/*     */       default:
/*  95 */         c.a(br.com.arremate.f.m.a);
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 100 */     Calendar calendar = (i1.has("dataInicioFormatada") && !i1.get("dataInicioFormatada").equals(i.NULL)) ? y.c(i1.getString("dataInicioFormatada")) : y.c(i1.getString("dataPrevisaoInicioFormatada"));
/* 101 */     c.b(calendar);
/*     */     
/* 103 */     ArrayList<c> arrayList = new ArrayList();
/* 104 */     arrayList.add(c);
/* 105 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private j c(String paramString) {
/* 109 */     if (paramString.contains("aguardando abertura da sessão") || paramString
/* 110 */       .contains("inscrição de propostas") || paramString
/* 111 */       .contains("aguardando agendamento") || paramString
/* 112 */       .contains("agendar retomada") || paramString
/* 113 */       .contains("aguardando reativação do pregão") || paramString
/* 114 */       .contains("sessão não iniciada"))
/* 115 */       return j.d; 
/* 116 */     if (paramString.contains("sessão iniciada")) {
/* 117 */       return j.a;
/*     */     }
/* 119 */     return j.g;
/*     */   }
/*     */ 
/*     */   
/*     */   private l a(String paramString) {
/* 124 */     switch (paramString) {
/*     */       case "ProcedimentoPregaoEletronico":
/*     */       case "ProcedimentoPregaoRegistroPrecoEletronico":
/* 127 */         return l.a;
/*     */     } 
/* 129 */     return l.c;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */