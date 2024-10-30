/*      */ package br.com.arremate.k.b;
/*      */ 
/*      */ import br.com.arremate.f.h;
/*      */ import br.com.arremate.f.w;
/*      */ import br.com.arremate.g.b;
/*      */ import br.com.arremate.g.e;
/*      */ import br.com.arremate.l.b;
/*      */ import br.com.arremate.l.h;
/*      */ import br.com.arremate.l.n;
/*      */ import br.com.arremate.l.q.b.e;
/*      */ import br.com.arremate.m.y;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.RoundingMode;
/*      */ import java.text.DecimalFormat;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.Random;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import org.slf4j.Logger;
/*      */ import org.slf4j.LoggerFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class a
/*      */ {
/*   30 */   protected static final Logger a = LoggerFactory.getLogger(a.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h a(e parame) {
/*   39 */     return a(parame.l(), parame.f(), parame
/*   40 */         .r(), parame.s(), parame
/*   41 */         .b(), parame.aU());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h a(double paramDouble, h paramh, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, b paramb, boolean paramBoolean) {
/*   58 */     return a(paramDouble, paramh, paramb
/*      */ 
/*      */         
/*   61 */         .f(), paramb
/*   62 */         .g(), paramb
/*   63 */         .a(), paramBoolean, paramb
/*      */         
/*   65 */         .h(), paramBigDecimal1, paramBigDecimal2, paramb
/*      */ 
/*      */         
/*   68 */         .E());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected h a(double paramDouble, h paramh, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, w paramw, boolean paramBoolean, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4, BigDecimal paramBigDecimal5, int paramInt) {
/*   92 */     double d1 = paramh.m();
/*   93 */     double d2 = a(d1, paramBigDecimal4, paramBigDecimal5);
/*      */ 
/*      */     
/*   96 */     if (paramDouble > d2 || (d2 == d1 && paramDouble >= d2))
/*      */     {
/*      */       
/*   99 */       return null;
/*      */     }
/*      */     
/*  102 */     h h1 = null;
/*      */     
/*  104 */     if (paramBoolean) {
/*  105 */       h1 = a(paramDouble, paramh, paramh, paramBigDecimal3, paramBigDecimal4, paramBigDecimal5, paramInt);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  115 */     if (h1 == null) {
/*  116 */       double d = a(paramBigDecimal1, paramBigDecimal2, paramBigDecimal4, paramBigDecimal5, paramw, d1, paramInt);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  124 */       h1 = new h(d);
/*      */     } 
/*      */     
/*  127 */     if (h1.m() < paramDouble) {
/*  128 */       h1.q(paramDouble);
/*      */     }
/*      */     
/*  131 */     h1.l(1);
/*  132 */     h1.an("Posição automática");
/*      */     
/*  134 */     return h1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected h a(double paramDouble, h paramh1, h paramh2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, int paramInt) {
/*  151 */     if (paramBigDecimal1.compareTo(BigDecimal.valueOf(5.01D)) == -1 || paramBigDecimal1
/*  152 */       .compareTo(BigDecimal.valueOf(20L)) == 1) {
/*  153 */       return null;
/*      */     }
/*      */     
/*  156 */     BigDecimal bigDecimal1 = BigDecimal.valueOf(paramh1.m());
/*      */     
/*  158 */     BigDecimal bigDecimal2 = bigDecimal1.subtract(BigDecimal.valueOf(0.01D));
/*      */     
/*  160 */     paramBigDecimal1 = a(paramBigDecimal1);
/*  161 */     paramBigDecimal1 = bigDecimal2.multiply(paramBigDecimal1);
/*  162 */     bigDecimal2 = bigDecimal2.subtract(paramBigDecimal1);
/*  163 */     double d1 = a(bigDecimal2.doubleValue(), paramInt);
/*      */     
/*  165 */     double d2 = a(paramh2.m(), paramBigDecimal2, paramBigDecimal3);
/*  166 */     if (d2 < d1) {
/*  167 */       d1 = d2;
/*  168 */       d1 = a(d1, paramInt);
/*      */     } 
/*      */     
/*  171 */     if (d1 >= paramDouble) {
/*  172 */       return new h(d1);
/*      */     }
/*      */ 
/*      */     
/*  176 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h a(List<h> paramList, e parame) throws e {
/*  188 */     b b = parame.b();
/*  189 */     return a(paramList, parame
/*      */         
/*  191 */         .l(), parame
/*  192 */         .f(), b
/*  193 */         .i(), parame
/*  194 */         .r(), parame
/*  195 */         .s(), b
/*  196 */         .E(), parame
/*  197 */         .aW());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected h a(List<h> paramList, double paramDouble1, double paramDouble2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, int paramInt, boolean paramBoolean) throws e {
/*  215 */     if (paramList == null || paramList
/*  216 */       .size() < 3 || paramBigDecimal1
/*  217 */       .compareTo(BigDecimal.ONE) == -1 || paramBigDecimal1
/*  218 */       .compareTo(BigDecimal.TEN) == 1) {
/*  219 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  232 */     BigDecimal bigDecimal1 = b(paramBigDecimal1);
/*      */     
/*  234 */     BigDecimal bigDecimal2 = BigDecimal.valueOf(((h)paramList.get(0)).m());
/*      */     
/*  236 */     BigDecimal bigDecimal3 = bigDecimal2.multiply(bigDecimal1);
/*      */     
/*  238 */     double d = bigDecimal3.doubleValue();
/*  239 */     d = a(d, paramInt);
/*      */ 
/*      */     
/*  242 */     if (d >= paramDouble2) {
/*  243 */       DecimalFormat decimalFormat1 = y.a("###,###,##0.0");
/*  244 */       String str1 = decimalFormat1.format(paramBigDecimal1);
/*      */       
/*  246 */       DecimalFormat decimalFormat2 = y.a("###,###,##0.0000");
/*  247 */       String str2 = decimalFormat2.format(bigDecimal2);
/*  248 */       String str3 = decimalFormat2.format(paramDouble2);
/*  249 */       throw new e(str1, str2, str3);
/*      */     } 
/*      */ 
/*      */     
/*  253 */     h h = new h(paramDouble2);
/*      */     
/*  255 */     for (byte b = 0; b < paramList.size(); b++) {
/*  256 */       h h1 = paramList.get(b);
/*      */       
/*  258 */       if (d <= h1.m()) {
/*  259 */         h = h1;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     
/*  265 */     BigDecimal bigDecimal4 = BigDecimal.valueOf(h.m());
/*  266 */     BigDecimal bigDecimal5 = BigDecimal.valueOf(paramDouble2);
/*  267 */     bigDecimal3 = BigDecimal.valueOf(d);
/*      */     
/*  269 */     if (paramBigDecimal2.compareTo(BigDecimal.ZERO) == 1) {
/*  270 */       bigDecimal5 = bigDecimal5.subtract(paramBigDecimal2);
/*      */ 
/*      */       
/*  273 */       if (bigDecimal5.compareTo(bigDecimal3) == -1) {
/*  274 */         d = bigDecimal5.doubleValue();
/*  275 */         d = a(d, paramInt);
/*      */       } 
/*  277 */     } else if (paramBigDecimal3.compareTo(BigDecimal.ZERO) == 1) {
/*  278 */       paramBigDecimal3 = b(paramBigDecimal3);
/*  279 */       bigDecimal5 = bigDecimal5.divide(paramBigDecimal3, 4, RoundingMode.HALF_DOWN);
/*      */ 
/*      */       
/*  282 */       if (bigDecimal5.compareTo(bigDecimal3) == -1) {
/*  283 */         d = bigDecimal5.doubleValue();
/*  284 */         d = a(d, paramInt);
/*      */       } 
/*  286 */     } else if (!h.bb() && bigDecimal4.compareTo(bigDecimal3) == 0) {
/*  287 */       BigDecimal bigDecimal6 = BigDecimal.valueOf(Math.pow(10.0D, paramInt));
/*  288 */       BigDecimal bigDecimal7 = BigDecimal.valueOf(1.0E-4D).multiply(bigDecimal6);
/*  289 */       d = a(bigDecimal7, bigDecimal7, paramBigDecimal2, paramBigDecimal3, w.a, h
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  295 */           .m(), paramInt);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  300 */     if (d >= paramDouble1) {
/*  301 */       if (paramBoolean) {
/*  302 */         BigDecimal bigDecimal6 = new BigDecimal(d);
/*  303 */         BigDecimal bigDecimal7 = new BigDecimal(((h)paramList.get(h.j() - 1)).m());
/*  304 */         BigDecimal bigDecimal8 = bigDecimal7.subtract(bigDecimal6);
/*  305 */         BigDecimal bigDecimal9 = a(bigDecimal6, paramBigDecimal3, paramBigDecimal2);
/*      */         
/*  307 */         if (bigDecimal8.compareTo(bigDecimal9) < 0) {
/*  308 */           h h2 = a(paramList, paramDouble1, paramDouble2, new BigDecimal(0.01D), new BigDecimal(0.01D), w.a, paramBigDecimal2, paramBigDecimal3, paramInt, paramBoolean, h
/*  309 */               .j());
/*  310 */           if (h2 != null) {
/*  311 */             h2.an(a(paramBigDecimal1, paramBoolean));
/*      */           }
/*      */           
/*  314 */           return h2;
/*      */         } 
/*      */       } 
/*      */       
/*  318 */       h h1 = new h(d);
/*  319 */       h1.l(h.j());
/*  320 */       h1.an(a(paramBigDecimal1, paramBoolean));
/*      */       
/*  322 */       return h1;
/*      */     } 
/*      */     
/*  325 */     return null;
/*      */   }
/*      */   
/*      */   private String a(BigDecimal paramBigDecimal, boolean paramBoolean) {
/*  329 */     DecimalFormat decimalFormat = y.a("###,###,##0.0");
/*  330 */     String str = String.join("", new CharSequence[] { "Ficar até ", decimalFormat.format(paramBigDecimal), "% do 1º colocado" });
/*      */     
/*  332 */     if (paramBoolean) {
/*  333 */       str = str + " respeitando interválo entre lances intermediários";
/*      */     }
/*      */     
/*  336 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h b(List<h> paramList, e parame) throws b {
/*  348 */     b b = parame.b();
/*  349 */     return a(paramList, parame
/*  350 */         .l(), parame
/*  351 */         .f(), b
/*  352 */         .f(), b
/*  353 */         .g(), b
/*  354 */         .a(), parame
/*  355 */         .r(), parame
/*  356 */         .s(), b
/*  357 */         .E(), parame
/*  358 */         .aW());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected h a(List<h> paramList, double paramDouble1, double paramDouble2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, w paramw, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4, int paramInt, boolean paramBoolean) throws b {
/*  378 */     if (paramList == null || paramList.size() < 3) {
/*  379 */       return null;
/*      */     }
/*      */     
/*  382 */     int i = a(paramList, paramDouble2);
/*  383 */     if (i > 0 && i <= 3) {
/*  384 */       throw new b();
/*      */     }
/*      */     
/*  387 */     h h = a(paramList, paramDouble1, paramDouble2, paramBigDecimal1, paramBigDecimal2, paramw, paramBigDecimal3, paramBigDecimal4, paramInt, paramBoolean, 3);
/*      */     
/*  389 */     if (h != null) {
/*  390 */       String str = "Top 3";
/*  391 */       if (paramBoolean) {
/*  392 */         str = str + " respeitando interválo entre lances intermediários";
/*      */       }
/*      */       
/*  395 */       h.an(str);
/*      */     } 
/*      */     
/*  398 */     return h;
/*      */   }
/*      */ 
/*      */   
/*      */   protected h a(List<h> paramList, double paramDouble1, double paramDouble2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, w paramw, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4, int paramInt1, boolean paramBoolean, int paramInt2) {
/*  403 */     if (paramList == null) {
/*  404 */       return null;
/*      */     }
/*      */     
/*  407 */     h h = null;
/*      */     
/*  409 */     ListIterator<h> listIterator = paramList.listIterator(paramInt2);
/*  410 */     while (listIterator.hasPrevious()) {
/*  411 */       h h1 = listIterator.previous();
/*  412 */       if (paramDouble2 < h1.m()) {
/*  413 */         return null;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  418 */       double d = listIterator.hasPrevious() ? a(paramDouble2, paramBigDecimal3, paramBigDecimal4) : a(h1.m(), paramBigDecimal3, paramBigDecimal4);
/*  419 */       if (paramDouble1 <= d) {
/*      */         double d1;
/*  421 */         if (paramBoolean) {
/*  422 */           d1 = a(paramBigDecimal1, paramBigDecimal2, paramBigDecimal3, paramBigDecimal4, paramw, h1.m(), paramInt1);
/*      */         } else {
/*  424 */           d1 = a(paramBigDecimal1, paramBigDecimal2, paramw, h1.m(), paramInt1);
/*      */         } 
/*  426 */         if (d1 > d) {
/*  427 */           d1 = d;
/*      */         }
/*      */         
/*  430 */         if (h == null) {
/*  431 */           if (d1 < paramDouble1) {
/*  432 */             return null;
/*      */           }
/*      */           
/*  435 */           h = new h(d1);
/*  436 */           h.l(h1.j());
/*      */         } 
/*      */         
/*  439 */         if (listIterator.hasPrevious()) {
/*  440 */           BigDecimal bigDecimal3; h h2 = listIterator.previous();
/*  441 */           BigDecimal bigDecimal1 = BigDecimal.valueOf(h2.m());
/*  442 */           BigDecimal bigDecimal2 = BigDecimal.valueOf(h.m());
/*      */ 
/*      */           
/*  445 */           if (bigDecimal2.compareTo(bigDecimal1) > 0) {
/*      */             break;
/*      */           }
/*      */ 
/*      */           
/*  450 */           if (paramBoolean) {
/*  451 */             bigDecimal3 = a(bigDecimal1, paramBigDecimal4, paramBigDecimal3);
/*      */           } else {
/*  453 */             bigDecimal3 = BigDecimal.valueOf(1.0E-4D);
/*      */           } 
/*      */ 
/*      */           
/*  457 */           BigDecimal bigDecimal4 = bigDecimal1.subtract(bigDecimal2);
/*  458 */           if (bigDecimal4.compareTo(bigDecimal3) < 0) {
/*  459 */             h = null;
/*      */           } else {
/*  461 */             h.l(h2.j());
/*      */           } 
/*      */           
/*  464 */           listIterator.next();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  469 */     return h;
/*      */   }
/*      */   
/*      */   private BigDecimal a(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3) {
/*  473 */     if (paramBigDecimal2.compareTo(BigDecimal.ZERO) == 1) {
/*  474 */       BigDecimal bigDecimal = paramBigDecimal2;
/*  475 */       bigDecimal = bigDecimal.divide(BigDecimal.valueOf(100L));
/*  476 */       bigDecimal = bigDecimal.multiply(paramBigDecimal1);
/*  477 */       return bigDecimal;
/*      */     } 
/*  479 */     return paramBigDecimal3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h c(List<h> paramList, e parame) throws br.com.arremate.g.a {
/*  492 */     b b = parame.b();
/*  493 */     return a(paramList, b
/*      */         
/*  495 */         .F(), parame
/*  496 */         .l(), parame
/*  497 */         .r(), parame
/*  498 */         .s(), b
/*  499 */         .E());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected h a(List<h> paramList, int paramInt1, double paramDouble, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, int paramInt2) throws br.com.arremate.g.a {
/*  515 */     if (paramList == null || paramList.size() < paramInt1) {
/*  516 */       return null;
/*      */     }
/*      */     
/*  519 */     h h1 = null;
/*      */     
/*  521 */     h h2 = paramList.get(paramInt1 - 1);
/*  522 */     if (!h2.bb()) {
/*  523 */       h h = paramList.get(0);
/*  524 */       BigDecimal bigDecimal1 = a(BigDecimal.TEN);
/*  525 */       BigDecimal bigDecimal2 = BigDecimal.valueOf(h2.m());
/*      */       
/*  527 */       bigDecimal2 = bigDecimal2.subtract(BigDecimal.valueOf(0.01D));
/*  528 */       bigDecimal1 = bigDecimal2.multiply(bigDecimal1);
/*  529 */       bigDecimal2 = bigDecimal2.subtract(bigDecimal1);
/*  530 */       double d1 = a(bigDecimal2.doubleValue(), paramInt2);
/*      */ 
/*      */       
/*  533 */       if (d1 >= h.m()) {
/*  534 */         DecimalFormat decimalFormat = y.a("###,###,##0.0000");
/*  535 */         String str1 = decimalFormat.format(h.m());
/*  536 */         String str2 = decimalFormat.format(bigDecimal2);
/*  537 */         throw new br.com.arremate.g.a(String.valueOf(paramInt1), str1, str2);
/*      */       } 
/*      */       
/*  540 */       double d2 = a(h.m(), paramBigDecimal1, paramBigDecimal2);
/*  541 */       if (d2 < d1) {
/*  542 */         d1 = d2;
/*  543 */         d1 = a(d1, paramInt2);
/*      */       } 
/*      */       
/*  546 */       if (d1 >= paramDouble) {
/*  547 */         h1 = new h(d1);
/*  548 */         h1.l(1);
/*  549 */         h1.an("Excluir o " + paramInt1 + "º colocado");
/*      */       } 
/*      */     } 
/*      */     
/*  553 */     return h1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int a(List<h> paramList, double paramDouble) {
/*  564 */     int i = 0;
/*      */     
/*  566 */     for (byte b = 0; b < paramList.size(); b++) {
/*  567 */       h h = paramList.get(b);
/*  568 */       if (h.m() == paramDouble) {
/*  569 */         i = b + 1;
/*      */         
/*  571 */         if (i >= paramList.size()) {
/*      */           break;
/*      */         }
/*      */         
/*  575 */         h h1 = paramList.get(i);
/*      */ 
/*      */         
/*  578 */         if (h1.m() > paramDouble) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  585 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal a(BigDecimal paramBigDecimal) {
/*  595 */     BigDecimal bigDecimal = paramBigDecimal;
/*  596 */     bigDecimal = bigDecimal.divide(BigDecimal.valueOf(100L));
/*  597 */     return bigDecimal;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal b(BigDecimal paramBigDecimal) {
/*  607 */     BigDecimal bigDecimal = paramBigDecimal;
/*  608 */     bigDecimal = bigDecimal.divide(BigDecimal.valueOf(100L)).add(BigDecimal.ONE);
/*  609 */     return bigDecimal;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal c(BigDecimal paramBigDecimal) {
/*  621 */     BigDecimal bigDecimal = a(paramBigDecimal);
/*  622 */     bigDecimal = BigDecimal.ONE.subtract(bigDecimal);
/*  623 */     return bigDecimal;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h d(List<h> paramList, e parame) {
/*  634 */     return a(paramList, parame
/*      */         
/*  636 */         .l(), parame
/*  637 */         .f(), parame
/*  638 */         .k(), parame
/*  639 */         .b(), parame
/*  640 */         .r(), parame
/*  641 */         .s());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected h a(List<h> paramList, double paramDouble1, double paramDouble2, double paramDouble3, b paramb, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2) {
/*  659 */     if (paramList == null || paramList.size() < 2) {
/*  660 */       return null;
/*      */     }
/*      */     
/*  663 */     h h1 = paramList.get(1);
/*  664 */     h h2 = a(h1, paramDouble1, paramDouble2, paramDouble3, paramb
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  669 */         .f(), paramb
/*  670 */         .g(), paramb
/*  671 */         .a(), paramBigDecimal1, paramBigDecimal2, paramb
/*      */ 
/*      */         
/*  674 */         .E());
/*      */     
/*  676 */     if (h2 != null) {
/*  677 */       h2.an("Desempate do primeiro lugar");
/*  678 */       h2.l(1);
/*      */     } 
/*      */     
/*  681 */     return h2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected h a(h paramh, double paramDouble1, double paramDouble2, double paramDouble3, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, w paramw, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4, int paramInt) {
/*  704 */     if (paramDouble2 <= paramDouble1 || paramDouble1 >= paramDouble3 || paramDouble1 <= 0.0D)
/*      */     {
/*      */       
/*  707 */       return null;
/*      */     }
/*      */     
/*  710 */     h h1 = null;
/*      */     
/*  712 */     if (paramh.m() == paramDouble2 && !paramh.bb()) {
/*  713 */       double d = a(paramBigDecimal1, paramBigDecimal2, paramBigDecimal3, paramBigDecimal4, paramw, paramDouble2, paramInt);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  722 */       if (d < paramDouble1) {
/*  723 */         d = paramDouble1;
/*      */       }
/*      */       
/*  726 */       h1 = new h(d);
/*      */     } 
/*      */     
/*  729 */     return h1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h a(List<h> paramList, double paramDouble1, double paramDouble2, double paramDouble3, n paramn, boolean paramBoolean, b paramb, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2) {
/*  752 */     if (!paramn.bk() || !paramBoolean || paramDouble2 == paramDouble1 || paramDouble1 >= paramDouble3 || paramDouble1 <= 0.0D)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  757 */       return null;
/*      */     }
/*      */     
/*  760 */     if (paramList == null || paramList.size() < 2) {
/*  761 */       return null;
/*      */     }
/*      */     
/*  764 */     BigDecimal bigDecimal1 = paramb.h();
/*  765 */     if (bigDecimal1.compareTo(BigDecimal.valueOf(5.01D)) == -1 || bigDecimal1
/*  766 */       .compareTo(BigDecimal.valueOf(20L)) == 1) {
/*  767 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  771 */     BigDecimal bigDecimal2 = BigDecimal.valueOf(paramDouble2);
/*  772 */     BigDecimal bigDecimal3 = c(bigDecimal1);
/*  773 */     BigDecimal bigDecimal4 = bigDecimal2.divide(bigDecimal3, 4, RoundingMode.DOWN);
/*  774 */     h h1 = paramList.get(1);
/*      */     
/*  776 */     if (h1 == null || h1.m() > bigDecimal4.doubleValue() || h1.bb()) {
/*  777 */       return null;
/*      */     }
/*      */     
/*  780 */     h h2 = paramList.get(0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  787 */     h h3 = a(paramDouble1, h1, h2, bigDecimal1, paramBigDecimal1, paramBigDecimal2, paramb
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  794 */         .E());
/*      */     
/*  796 */     if (h3 != null) {
/*  797 */       h3.an("Distanciamento de ME/EPP");
/*  798 */       h3.l(1);
/*      */     } 
/*      */     
/*  801 */     return h3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h e(List<h> paramList, e parame) {
/*  813 */     return a(1, paramList, parame);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h a(int paramInt, List<h> paramList, e parame) {
/*  826 */     b b = parame.b();
/*      */     
/*      */     try {
/*  829 */       if (!b.aE()) {
/*  830 */         return null;
/*      */       }
/*      */ 
/*      */       
/*  834 */       double d = a(parame.f(), parame
/*  835 */           .r(), parame.s());
/*  836 */       if (d < parame.l()) {
/*  837 */         return null;
/*      */       }
/*      */       
/*  840 */       for (int i = paramInt; i < paramList.size(); i++) {
/*  841 */         h h = paramList.get(i);
/*  842 */         double d1 = parame.f();
/*      */         
/*  844 */         if (h.m() == d1) {
/*  845 */           int j = i + 1;
/*      */ 
/*      */           
/*  848 */           if (j >= paramList.size()) {
/*      */             break;
/*      */           }
/*      */           
/*  852 */           h h1 = paramList.get(j);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  859 */           if (h1.m() > d1) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  865 */         if (parame.l() < h.m() && d1 >= h.m()) {
/*      */ 
/*      */           
/*  868 */           double d2 = a(b
/*  869 */               .f(), b
/*  870 */               .g(), b
/*  871 */               .a(), h
/*  872 */               .m(), b
/*  873 */               .E());
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  878 */           if (parame.aW()) {
/*  879 */             double d3 = a(h.m(), parame.r(), parame.s());
/*  880 */             if (d3 < d2) {
/*  881 */               d2 = d3;
/*      */               
/*  883 */               if (d2 < parame.l()) {
/*      */                 continue;
/*      */               }
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/*  890 */           if (d2 > d) {
/*  891 */             d2 = d;
/*      */           }
/*      */           
/*  894 */           if (d2 < parame.l()) {
/*  895 */             d2 = parame.l();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  903 */           if (((h)paramList.get(i - 1)).m() != d2)
/*      */           
/*      */           { 
/*      */             
/*  907 */             h h1 = new h(d2);
/*  908 */             h1.l(h.j());
/*  909 */             h1.c(h.b());
/*      */             
/*  911 */             int j = parame.j();
/*  912 */             if (j != h.i.v()) {
/*  913 */               h1.an("Posição fixa");
/*      */             } else {
/*  915 */               h1.an("Posição automática");
/*      */             } 
/*      */             
/*  918 */             return h1; } 
/*      */         }  continue;
/*      */       } 
/*  921 */     } catch (Exception exception) {
/*  922 */       a.info("Error at calcularLanceDemaisPosicoes()", exception);
/*      */     } 
/*      */     
/*  925 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String a(List<h> paramList, double paramDouble) {
/*  937 */     for (byte b = 1; b < paramList.size(); b++) {
/*  938 */       h h = paramList.get(b);
/*      */ 
/*      */       
/*  941 */       if (h.m() == paramDouble) {
/*  942 */         String str = String.join(" ", new CharSequence[] { Integer.toString(h.j()), "° Lugar" });
/*  943 */         int i = b + 1;
/*      */ 
/*      */         
/*  946 */         if (i >= paramList.size()) {
/*  947 */           return str;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  954 */         if (((h)paramList.get(i)).m() != paramDouble) {
/*  955 */           return str;
/*      */         }
/*  957 */         return String.join(" ", new CharSequence[] { str, "- Empate" });
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  963 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private double a(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, w paramw, double paramDouble, int paramInt) {
/*  978 */     return a(paramBigDecimal1, paramBigDecimal2, BigDecimal.ZERO, BigDecimal.ZERO, paramw, paramDouble, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected double a(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4, w paramw, double paramDouble, int paramInt) {
/*      */     BigDecimal bigDecimal3;
/*  998 */     byte b = 4;
/*      */     
/* 1000 */     if (paramw == w.a) {
/* 1001 */       if (paramBigDecimal4.compareTo(BigDecimal.ZERO) == 1) {
/* 1002 */         BigDecimal bigDecimal = paramBigDecimal4;
/* 1003 */         bigDecimal = bigDecimal.divide(BigDecimal.valueOf(100L));
/* 1004 */         bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(paramDouble));
/* 1005 */         paramBigDecimal3 = bigDecimal;
/*      */       } 
/*      */       
/* 1008 */       if (paramBigDecimal3.compareTo(BigDecimal.ZERO) == 1) {
/* 1009 */         if (paramBigDecimal1.compareTo(paramBigDecimal3) == -1) {
/* 1010 */           paramBigDecimal1 = paramBigDecimal3;
/*      */         }
/*      */         
/* 1013 */         if (paramBigDecimal2.compareTo(paramBigDecimal3) == -1) {
/* 1014 */           paramBigDecimal2 = paramBigDecimal3;
/*      */         }
/*      */       }
/*      */     
/* 1018 */     } else if (paramBigDecimal4.compareTo(BigDecimal.ZERO) == 1) {
/* 1019 */       BigDecimal bigDecimal = paramBigDecimal4;
/* 1020 */       bigDecimal = bigDecimal.divide(BigDecimal.valueOf(100L));
/*      */       
/* 1022 */       if (paramBigDecimal1.compareTo(bigDecimal) == -1) {
/* 1023 */         paramBigDecimal1 = bigDecimal;
/*      */       }
/*      */       
/* 1026 */       if (paramBigDecimal2.compareTo(bigDecimal) == -1) {
/* 1027 */         paramBigDecimal2 = bigDecimal;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1032 */     BigDecimal bigDecimal1 = BigDecimal.valueOf(paramDouble);
/* 1033 */     BigDecimal bigDecimal2 = paramBigDecimal1;
/*      */     
/* 1035 */     if (paramBigDecimal2.compareTo(paramBigDecimal1) == 1) {
/* 1036 */       Random random = new Random();
/* 1037 */       BigDecimal bigDecimal4 = paramBigDecimal1;
/* 1038 */       BigDecimal bigDecimal5 = paramBigDecimal2;
/* 1039 */       BigDecimal bigDecimal6 = bigDecimal5.subtract(bigDecimal4);
/*      */       
/* 1041 */       bigDecimal2 = BigDecimal.valueOf(random.nextDouble()).multiply(bigDecimal6);
/* 1042 */       bigDecimal2 = bigDecimal2.add(paramBigDecimal1);
/* 1043 */       bigDecimal2 = bigDecimal2.setScale(b, RoundingMode.HALF_DOWN);
/*      */       
/* 1045 */       if (bigDecimal2.compareTo(bigDecimal4) == -1) {
/* 1046 */         bigDecimal2 = bigDecimal4;
/* 1047 */       } else if (bigDecimal2.compareTo(bigDecimal5) == 1) {
/* 1048 */         bigDecimal2 = bigDecimal5;
/*      */       } 
/*      */     } 
/*      */     
/* 1052 */     switch (null.k[paramw.ordinal()])
/*      */     
/*      */     { case 1:
/* 1055 */         bigDecimal2 = bigDecimal2.multiply(bigDecimal1);
/* 1056 */         bigDecimal3 = paramBigDecimal3;
/*      */ 
/*      */         
/* 1059 */         if (bigDecimal2.compareTo(bigDecimal3) == -1) {
/* 1060 */           bigDecimal2 = bigDecimal3;
/*      */         }
/*      */ 
/*      */         
/* 1064 */         bigDecimal1 = bigDecimal1.subtract(bigDecimal2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1071 */         return a(bigDecimal1.doubleValue(), paramInt); }  bigDecimal1 = bigDecimal1.subtract(bigDecimal2); return a(bigDecimal1.doubleValue(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected double a(double paramDouble, int paramInt) {
/* 1082 */     byte b = 4;
/* 1083 */     double d = 0.0D;
/*      */     
/* 1085 */     if (paramInt >= 0 && paramInt <= 8) {
/* 1086 */       if (paramInt < b) {
/* 1087 */         paramInt = Math.abs(paramInt - b);
/* 1088 */         d = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.DOWN).doubleValue();
/*      */       } else {
/* 1090 */         d = BigDecimal.valueOf(paramDouble).intValue();
/*      */         
/* 1092 */         if (paramInt > b) {
/* 1093 */           int i = paramInt - b + 1;
/* 1094 */           i = Integer.valueOf(StringUtils.rightPad("1", i, "0")).intValue();
/* 1095 */           d -= d % i;
/*      */         } 
/*      */       } 
/*      */     } else {
/* 1099 */       d = BigDecimal.valueOf(paramDouble).setScale(b, RoundingMode.DOWN).doubleValue();
/*      */     } 
/*      */     
/* 1102 */     if (d > 0.0D) {
/* 1103 */       paramDouble = d;
/*      */     } else {
/* 1105 */       paramDouble = BigDecimal.valueOf(paramDouble).setScale(b, RoundingMode.DOWN).doubleValue();
/*      */     } 
/*      */     
/* 1108 */     return paramDouble;
/*      */   }
/*      */   
/*      */   protected double a(double paramDouble, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2) {
/* 1112 */     if (paramBigDecimal1.compareTo(BigDecimal.ZERO) == 1)
/* 1113 */       return a(BigDecimal.valueOf(paramDouble).subtract(paramBigDecimal1).doubleValue(), 0); 
/* 1114 */     if (paramBigDecimal2.compareTo(BigDecimal.ZERO) == 1) {
/* 1115 */       return a(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, paramBigDecimal2, w.b, paramDouble, 0);
/*      */     }
/*      */ 
/*      */     
/* 1119 */     return paramDouble;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */