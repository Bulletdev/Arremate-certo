/*      */ package com.google.a.l;
/*      */ 
/*      */ import com.google.a.a.a;
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.c;
/*      */ import com.google.a.b.e;
/*      */ import com.google.a.b.s;
/*      */ import com.google.a.b.w;
/*      */ import com.google.a.b.x;
/*      */ import com.google.a.b.y;
/*      */ import com.google.a.b.z;
/*      */ import com.google.a.d.bR;
/*      */ import com.google.a.d.bW;
/*      */ import com.google.a.d.bZ;
/*      */ import com.google.a.d.bi;
/*      */ import com.google.a.d.bp;
/*      */ import com.google.a.d.bt;
/*      */ import com.google.a.d.cb;
/*      */ import com.google.a.d.dj;
/*      */ import com.google.b.a.a.b;
/*      */ import com.google.b.a.j;
/*      */ import java.nio.charset.Charset;
/*      */ import java.util.Collection;
/*      */ import java.util.Map;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @j
/*      */ @a
/*      */ @b
/*      */ public final class f
/*      */ {
/*      */   private static final String iE = "charset";
/*   81 */   private static final bi<String, String> b = bi.a("charset", c.ag(com.google.a.b.f.UTF_8.name()));
/*      */ 
/*      */ 
/*      */   
/*   85 */   private static final e o = e.e()
/*   86 */     .a(e.l().o())
/*   87 */     .a(e.b(' '))
/*   88 */     .a(e.b("()<>@,;:\\\"/[]?="));
/*      */   
/*   90 */   private static final e p = e.e().a(e.b("\"\\\r"));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   96 */   private static final e q = e.a(" \t\r\n");
/*      */   
/*      */   private static final String iF = "application";
/*      */   
/*      */   private static final String iG = "audio";
/*      */   
/*      */   private static final String iH = "image";
/*      */   
/*      */   private static final String iI = "text";
/*      */   private static final String iJ = "video";
/*      */   private static final String iK = "font";
/*      */   private static final String iL = "*";
/*  108 */   private static final Map<f, f> af = bW.a();
/*      */ 
/*      */   
/*      */   private static f a(String paramString1, String paramString2) {
/*  112 */     f f1 = a(new f(paramString1, paramString2, bi.a()));
/*  113 */     f1.d = z.b();
/*  114 */     return f1;
/*      */   }
/*      */   
/*      */   private static f b(String paramString1, String paramString2) {
/*  118 */     f f1 = a(new f(paramString1, paramString2, (bi<String, String>)b));
/*  119 */     f1.d = z.a(com.google.a.b.f.UTF_8);
/*  120 */     return f1;
/*      */   }
/*      */   
/*      */   private static f a(f paramf) {
/*  124 */     af.put(paramf, paramf);
/*  125 */     return paramf;
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
/*  138 */   public static final f a = a("*", "*");
/*  139 */   public static final f b = a("text", "*");
/*  140 */   public static final f c = a("image", "*");
/*  141 */   public static final f d = a("audio", "*");
/*  142 */   public static final f e = a("video", "*");
/*  143 */   public static final f f = a("application", "*");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  150 */   public static final f g = a("font", "*");
/*      */ 
/*      */ 
/*      */   
/*  154 */   public static final f h = b("text", "cache-manifest");
/*  155 */   public static final f i = b("text", "css");
/*  156 */   public static final f j = b("text", "csv");
/*  157 */   public static final f k = b("text", "html");
/*  158 */   public static final f l = b("text", "calendar");
/*  159 */   public static final f m = b("text", "plain");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  166 */   public static final f n = b("text", "javascript");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  173 */   public static final f o = b("text", "tab-separated-values");
/*      */   
/*  175 */   public static final f p = b("text", "vcard");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  183 */   public static final f q = b("text", "vnd.wap.wml");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  190 */   public static final f r = b("text", "xml");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  198 */   public static final f s = b("text", "vtt");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  207 */   public static final f t = a("image", "bmp");
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
/*  218 */   public static final f u = a("image", "x-canon-crw");
/*      */   
/*  220 */   public static final f v = a("image", "gif");
/*  221 */   public static final f w = a("image", "vnd.microsoft.icon");
/*  222 */   public static final f x = a("image", "jpeg");
/*  223 */   public static final f y = a("image", "png");
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
/*  242 */   public static final f z = a("image", "vnd.adobe.photoshop");
/*      */   
/*  244 */   public static final f A = b("image", "svg+xml");
/*  245 */   public static final f B = a("image", "tiff");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  252 */   public static final f C = a("image", "webp");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  259 */   public static final f D = a("image", "heif");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  266 */   public static final f E = a("image", "jp2");
/*      */ 
/*      */   
/*  269 */   public static final f F = a("audio", "mp4");
/*  270 */   public static final f G = a("audio", "mpeg");
/*  271 */   public static final f H = a("audio", "ogg");
/*  272 */   public static final f I = a("audio", "webm");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  279 */   public static final f J = a("audio", "l16");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  286 */   public static final f K = a("audio", "l24");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  294 */   public static final f L = a("audio", "basic");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  302 */   public static final f M = a("audio", "aac");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  309 */   public static final f N = a("audio", "vorbis");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  318 */   public static final f O = a("audio", "x-ms-wma");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  327 */   public static final f P = a("audio", "x-ms-wax");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  335 */   public static final f Q = a("audio", "vnd.rn-realaudio");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  342 */   public static final f R = a("audio", "vnd.wave");
/*      */ 
/*      */   
/*  345 */   public static final f S = a("video", "mp4");
/*  346 */   public static final f T = a("video", "mpeg");
/*  347 */   public static final f U = a("video", "ogg");
/*  348 */   public static final f V = a("video", "quicktime");
/*  349 */   public static final f W = a("video", "webm");
/*  350 */   public static final f X = a("video", "x-ms-wmv");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  359 */   public static final f Y = a("video", "x-flv");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  368 */   public static final f Z = a("video", "3gpp");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  377 */   public static final f aa = a("video", "3gpp2");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  387 */   public static final f ab = b("application", "xml");
/*      */   
/*  389 */   public static final f ac = b("application", "atom+xml");
/*  390 */   public static final f ad = a("application", "x-bzip2");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  398 */   public static final f ae = b("application", "dart");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  406 */   public static final f af = a("application", "vnd.apple.pkpass");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  415 */   public static final f ag = a("application", "vnd.ms-fontobject");
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
/*  426 */   public static final f ah = a("application", "epub+zip");
/*      */ 
/*      */   
/*  429 */   public static final f ai = a("application", "x-www-form-urlencoded");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  438 */   public static final f aj = a("application", "pkcs12");
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
/*  450 */   public static final f ak = a("application", "binary");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  458 */   public static final f al = a("application", "geo+json");
/*      */   
/*  460 */   public static final f am = a("application", "x-gzip");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  468 */   public static final f an = a("application", "hal+json");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  476 */   public static final f ao = b("application", "javascript");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  484 */   public static final f ap = a("application", "jose");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  492 */   public static final f aq = a("application", "jose+json");
/*      */   
/*  494 */   public static final f ar = b("application", "json");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  502 */   public static final f as = b("application", "manifest+json");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  507 */   public static final f at = a("application", "vnd.google-earth.kml+xml");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  513 */   public static final f au = a("application", "vnd.google-earth.kmz");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  520 */   public static final f av = a("application", "mbox");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  528 */   public static final f aw = a("application", "x-apple-aspen-config");
/*      */ 
/*      */   
/*  531 */   public static final f ax = a("application", "vnd.ms-excel");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  539 */   public static final f ay = a("application", "vnd.ms-outlook");
/*      */ 
/*      */ 
/*      */   
/*  543 */   public static final f az = a("application", "vnd.ms-powerpoint");
/*      */ 
/*      */   
/*  546 */   public static final f aA = a("application", "msword");
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
/*  558 */   public static final f aB = a("application", "dash+xml");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  566 */   public static final f aC = a("application", "wasm");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  575 */   public static final f aD = a("application", "x-nacl");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  585 */   public static final f aE = a("application", "x-pnacl");
/*      */   
/*  587 */   public static final f aF = a("application", "octet-stream");
/*      */   
/*  589 */   public static final f aG = a("application", "ogg");
/*      */   
/*  591 */   public static final f aH = a("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
/*      */ 
/*      */   
/*  594 */   public static final f aI = a("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
/*      */ 
/*      */   
/*  597 */   public static final f aJ = a("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
/*      */   
/*  599 */   public static final f aK = a("application", "vnd.oasis.opendocument.graphics");
/*      */   
/*  601 */   public static final f aL = a("application", "vnd.oasis.opendocument.presentation");
/*      */   
/*  603 */   public static final f aM = a("application", "vnd.oasis.opendocument.spreadsheet");
/*      */   
/*  605 */   public static final f aN = a("application", "vnd.oasis.opendocument.text");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  615 */   public static final f aO = b("application", "opensearchdescription+xml");
/*      */   
/*  617 */   public static final f aP = a("application", "pdf");
/*  618 */   public static final f aQ = a("application", "postscript");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  625 */   public static final f aR = a("application", "protobuf");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  635 */   public static final f aS = b("application", "rdf+xml");
/*      */   
/*  637 */   public static final f aT = b("application", "rtf");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  646 */   public static final f aU = a("application", "font-sfnt");
/*      */ 
/*      */   
/*  649 */   public static final f aV = a("application", "x-shockwave-flash");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  657 */   public static final f aW = a("application", "vnd.sketchup.skp");
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
/*  670 */   public static final f aX = b("application", "soap+xml");
/*      */   
/*  672 */   public static final f aY = a("application", "x-tar");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  681 */   public static final f aZ = a("application", "font-woff");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  690 */   public static final f ba = a("application", "font-woff2");
/*      */   
/*  692 */   public static final f bb = b("application", "xhtml+xml");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  702 */   public static final f bc = b("application", "xrd+xml");
/*      */   
/*  704 */   public static final f bd = a("application", "zip");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  714 */   public static final f be = a("font", "collection");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  722 */   public static final f bf = a("font", "otf");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  732 */   public static final f bg = a("font", "sfnt");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  740 */   public static final f bh = a("font", "ttf");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  750 */   public static final f bi = a("font", "woff");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  760 */   public static final f bj = a("font", "woff2");
/*      */   
/*      */   private final String type;
/*      */   private final String iM;
/*      */   private final bi<String, String> c;
/*      */   @b
/*      */   private String toString;
/*      */   @b
/*      */   private int hashCode;
/*      */   @b
/*      */   private z<Charset> d;
/*      */   
/*      */   private f(String paramString1, String paramString2, bi<String, String> parambi) {
/*  773 */     this.type = paramString1;
/*  774 */     this.iM = paramString2;
/*  775 */     this.c = parambi;
/*      */   }
/*      */ 
/*      */   
/*      */   public String do() {
/*  780 */     return this.type;
/*      */   }
/*      */ 
/*      */   
/*      */   public String dp() {
/*  785 */     return this.iM;
/*      */   }
/*      */ 
/*      */   
/*      */   public bi<String, String> e() {
/*  790 */     return this.c;
/*      */   }
/*      */   
/*      */   private Map<String, bp<String>> N() {
/*  794 */     return bW.a((Map)this.c
/*  795 */         .h(), new s<Collection<String>, bp<String>>(this)
/*      */         {
/*      */           public bp<String> c(Collection<String> param1Collection)
/*      */           {
/*  799 */             return bp.a(param1Collection);
/*      */           }
/*      */         });
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
/*      */   public z<Charset> g() {
/*  814 */     z<Charset> z1 = this.d;
/*  815 */     if (z1 == null) {
/*  816 */       String str = null;
/*  817 */       z1 = z.b();
/*  818 */       for (dj<String> dj = this.c.b("charset").b(); dj.hasNext(); ) { String str1 = dj.next();
/*  819 */         if (str == null) {
/*  820 */           str = str1;
/*  821 */           z1 = z.a(Charset.forName(str)); continue;
/*  822 */         }  if (!str.equals(str1)) {
/*  823 */           String str2 = str; throw new IllegalStateException((new StringBuilder(35 + String.valueOf(str2).length() + String.valueOf(str1).length())).append("Multiple charset values defined: ").append(str2).append(", ").append(str1).toString());
/*      */         }  }
/*      */ 
/*      */       
/*  827 */       this.d = z1;
/*      */     } 
/*  829 */     return z1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f a() {
/*  837 */     return this.c.isEmpty() ? this : d(this.type, this.iM);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f a(bZ<String, String> parambZ) {
/*  846 */     return a(this.type, this.iM, parambZ);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f a(String paramString, Iterable<String> paramIterable) {
/*  857 */     D.checkNotNull(paramString);
/*  858 */     D.checkNotNull(paramIterable);
/*  859 */     String str = av(paramString);
/*  860 */     bi.a a1 = bi.a();
/*  861 */     for (dj<Map.Entry> dj = this.c.e().b(); dj.hasNext(); ) { Map.Entry entry = dj.next();
/*  862 */       String str1 = (String)entry.getKey();
/*  863 */       if (!str.equals(str1)) {
/*  864 */         a1.a(str1, entry.getValue());
/*      */       } }
/*      */     
/*  867 */     for (String str1 : paramIterable) {
/*  868 */       a1.a(str, m(str, str1));
/*      */     }
/*  870 */     f f1 = new f(this.type, this.iM, a1.d());
/*      */     
/*  872 */     if (!str.equals("charset")) {
/*  873 */       f1.d = this.d;
/*      */     }
/*      */     
/*  876 */     return (f)x.a(af.get(f1), f1);
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
/*      */   public f c(String paramString1, String paramString2) {
/*  888 */     return a(paramString1, (Iterable<String>)bt.b(paramString2));
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
/*      */   public f a(Charset paramCharset) {
/*  901 */     D.checkNotNull(paramCharset);
/*  902 */     f f1 = c("charset", paramCharset.name());
/*      */     
/*  904 */     f1.d = z.a(paramCharset);
/*  905 */     return f1;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean dp() {
/*  910 */     return ("*".equals(this.type) || "*".equals(this.iM));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean a(f paramf) {
/*  943 */     return ((paramf.type.equals("*") || paramf.type.equals(this.type)) && (paramf.iM
/*  944 */       .equals("*") || paramf.iM.equals(this.iM)) && this.c
/*  945 */       .e().containsAll((Collection)paramf.c.e()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static f d(String paramString1, String paramString2) {
/*  955 */     f f1 = a(paramString1, paramString2, (bZ<String, String>)bi.a());
/*  956 */     f1.d = z.b();
/*  957 */     return f1;
/*      */   }
/*      */ 
/*      */   
/*      */   private static f a(String paramString1, String paramString2, bZ<String, String> parambZ) {
/*  962 */     D.checkNotNull(paramString1);
/*  963 */     D.checkNotNull(paramString2);
/*  964 */     D.checkNotNull(parambZ);
/*  965 */     String str1 = av(paramString1);
/*  966 */     String str2 = av(paramString2);
/*  967 */     D.a((
/*  968 */         !"*".equals(str1) || "*".equals(str2)), "A wildcard type cannot be used with a non-wildcard subtype");
/*      */     
/*  970 */     bi.a a1 = bi.a();
/*  971 */     for (Map.Entry entry : parambZ.entries()) {
/*  972 */       String str = av((String)entry.getKey());
/*  973 */       a1.a(str, m(str, (String)entry.getValue()));
/*      */     } 
/*  975 */     f f1 = new f(str1, str2, a1.d());
/*      */     
/*  977 */     return (f)x.a(af.get(f1), f1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static f a(String paramString) {
/*  986 */     return d("application", paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static f b(String paramString) {
/*  995 */     return d("audio", paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static f c(String paramString) {
/* 1004 */     return d("font", paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static f d(String paramString) {
/* 1013 */     return d("image", paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static f e(String paramString) {
/* 1022 */     return d("text", paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static f f(String paramString) {
/* 1031 */     return d("video", paramString);
/*      */   }
/*      */   
/*      */   private static String av(String paramString) {
/* 1035 */     D.checkArgument(o.b(paramString));
/* 1036 */     D.checkArgument(!paramString.isEmpty());
/* 1037 */     return c.ag(paramString);
/*      */   }
/*      */   
/*      */   private static String m(String paramString1, String paramString2) {
/* 1041 */     D.checkNotNull(paramString2);
/* 1042 */     D.a(e.e().b(paramString2), "parameter values must be ASCII: %s", paramString2);
/* 1043 */     return "charset".equals(paramString1) ? c.ag(paramString2) : paramString2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static f g(String paramString) {
/* 1052 */     D.checkNotNull(paramString);
/* 1053 */     a a1 = new a(paramString);
/*      */     try {
/* 1055 */       String str1 = a1.b((e)o);
/* 1056 */       a1.c('/');
/* 1057 */       String str2 = a1.b((e)o);
/* 1058 */       bi.a a2 = bi.a();
/* 1059 */       while (a1.dq()) {
/* 1060 */         String str4; a1.a((e)q);
/* 1061 */         a1.c(';');
/* 1062 */         a1.a((e)q);
/* 1063 */         String str3 = a1.b((e)o);
/* 1064 */         a1.c('=');
/*      */         
/* 1066 */         if ('"' == a1.a()) {
/* 1067 */           a1.c('"');
/* 1068 */           StringBuilder stringBuilder = new StringBuilder();
/* 1069 */           while ('"' != a1.a()) {
/* 1070 */             if ('\\' == a1.a()) {
/* 1071 */               a1.c('\\');
/* 1072 */               stringBuilder.append(a1.a(e.e())); continue;
/*      */             } 
/* 1074 */             stringBuilder.append(a1.b((e)p));
/*      */           } 
/*      */           
/* 1077 */           str4 = stringBuilder.toString();
/* 1078 */           a1.c('"');
/*      */         } else {
/* 1080 */           str4 = a1.b((e)o);
/*      */         } 
/* 1082 */         a2.a(str3, str4);
/*      */       } 
/* 1084 */       return a(str1, str2, (bZ<String, String>)a2.d());
/* 1085 */     } catch (IllegalStateException illegalStateException) {
/* 1086 */       throw new IllegalArgumentException((new StringBuilder(18 + String.valueOf(paramString).length())).append("Could not parse '").append(paramString).append("'").toString(), illegalStateException);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static final class a {
/*      */     final String iN;
/* 1092 */     int position = 0;
/*      */     
/*      */     a(String param1String) {
/* 1095 */       this.iN = param1String;
/*      */     }
/*      */     
/*      */     String a(e param1e) {
/* 1099 */       D.ab(dq());
/* 1100 */       int i = this.position;
/* 1101 */       this.position = param1e.o().a(this.iN, i);
/* 1102 */       return dq() ? this.iN.substring(i, this.position) : this.iN.substring(i);
/*      */     }
/*      */     
/*      */     String b(e param1e) {
/* 1106 */       int i = this.position;
/* 1107 */       String str = a(param1e);
/* 1108 */       D.ab((this.position != i));
/* 1109 */       return str;
/*      */     }
/*      */     
/*      */     char a(e param1e) {
/* 1113 */       D.ab(dq());
/* 1114 */       char c = a();
/* 1115 */       D.ab(param1e.matches(c));
/* 1116 */       this.position++;
/* 1117 */       return c;
/*      */     }
/*      */     
/*      */     char c(char param1Char) {
/* 1121 */       D.ab(dq());
/* 1122 */       D.ab((a() == param1Char));
/* 1123 */       this.position++;
/* 1124 */       return param1Char;
/*      */     }
/*      */     
/*      */     char a() {
/* 1128 */       D.ab(dq());
/* 1129 */       return this.iN.charAt(this.position);
/*      */     }
/*      */     
/*      */     boolean dq() {
/* 1133 */       return (this.position >= 0 && this.position < this.iN.length());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 1139 */     if (paramObject == this)
/* 1140 */       return true; 
/* 1141 */     if (paramObject instanceof f) {
/* 1142 */       f f1 = (f)paramObject;
/* 1143 */       return (this.type.equals(f1.type) && this.iM
/* 1144 */         .equals(f1.iM) && 
/*      */         
/* 1146 */         N().equals(f1.N()));
/*      */     } 
/* 1148 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1155 */     int i = this.hashCode;
/* 1156 */     if (i == 0) {
/* 1157 */       i = y.a(new Object[] { this.type, this.iM, N() });
/* 1158 */       this.hashCode = i;
/*      */     } 
/* 1160 */     return i;
/*      */   }
/*      */   
/* 1163 */   private static final w.a a = w.a("; ").a("=");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1172 */     String str = this.toString;
/* 1173 */     if (str == null) {
/* 1174 */       str = dq();
/* 1175 */       this.toString = str;
/*      */     } 
/* 1177 */     return str;
/*      */   }
/*      */   
/*      */   private String dq() {
/* 1181 */     StringBuilder stringBuilder = (new StringBuilder()).append(this.type).append('/').append(this.iM);
/* 1182 */     if (!this.c.isEmpty()) {
/* 1183 */       stringBuilder.append("; ");
/*      */       
/* 1185 */       bR bR = cb.a((bR)this.c, new s<String, String>(this)
/*      */           {
/*      */             
/*      */             public String apply(String param1String)
/*      */             {
/* 1190 */               return (f.r().b(param1String) && !param1String.isEmpty()) ? 
/* 1191 */                 param1String : 
/* 1192 */                 f.al(param1String);
/*      */             }
/*      */           });
/* 1195 */       a.a(stringBuilder, bR.entries());
/*      */     } 
/* 1197 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private static String aw(String paramString) {
/* 1201 */     StringBuilder stringBuilder = (new StringBuilder(paramString.length() + 16)).append('"');
/* 1202 */     for (byte b = 0; b < paramString.length(); b++) {
/* 1203 */       char c = paramString.charAt(b);
/* 1204 */       if (c == '\r' || c == '\\' || c == '"') {
/* 1205 */         stringBuilder.append('\\');
/*      */       }
/* 1207 */       stringBuilder.append(c);
/*      */     } 
/* 1209 */     return stringBuilder.append('"').toString();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\l\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */