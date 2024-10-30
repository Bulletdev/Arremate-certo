/*     */ package org.apache.commons.text.translate;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityArrays
/*     */ {
/*     */   public static final Map<CharSequence, CharSequence> ISO8859_1_ESCAPE;
/*     */   
/*     */   static {
/*  39 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  40 */     hashMap.put(" ", "&nbsp;");
/*  41 */     hashMap.put("¡", "&iexcl;");
/*  42 */     hashMap.put("¢", "&cent;");
/*  43 */     hashMap.put("£", "&pound;");
/*  44 */     hashMap.put("¤", "&curren;");
/*  45 */     hashMap.put("¥", "&yen;");
/*  46 */     hashMap.put("¦", "&brvbar;");
/*  47 */     hashMap.put("§", "&sect;");
/*  48 */     hashMap.put("¨", "&uml;");
/*  49 */     hashMap.put("©", "&copy;");
/*  50 */     hashMap.put("ª", "&ordf;");
/*  51 */     hashMap.put("«", "&laquo;");
/*  52 */     hashMap.put("¬", "&not;");
/*  53 */     hashMap.put("­", "&shy;");
/*  54 */     hashMap.put("®", "&reg;");
/*  55 */     hashMap.put("¯", "&macr;");
/*  56 */     hashMap.put("°", "&deg;");
/*  57 */     hashMap.put("±", "&plusmn;");
/*  58 */     hashMap.put("²", "&sup2;");
/*  59 */     hashMap.put("³", "&sup3;");
/*  60 */     hashMap.put("´", "&acute;");
/*  61 */     hashMap.put("µ", "&micro;");
/*  62 */     hashMap.put("¶", "&para;");
/*  63 */     hashMap.put("·", "&middot;");
/*  64 */     hashMap.put("¸", "&cedil;");
/*  65 */     hashMap.put("¹", "&sup1;");
/*  66 */     hashMap.put("º", "&ordm;");
/*  67 */     hashMap.put("»", "&raquo;");
/*  68 */     hashMap.put("¼", "&frac14;");
/*  69 */     hashMap.put("½", "&frac12;");
/*  70 */     hashMap.put("¾", "&frac34;");
/*  71 */     hashMap.put("¿", "&iquest;");
/*  72 */     hashMap.put("À", "&Agrave;");
/*  73 */     hashMap.put("Á", "&Aacute;");
/*  74 */     hashMap.put("Â", "&Acirc;");
/*  75 */     hashMap.put("Ã", "&Atilde;");
/*  76 */     hashMap.put("Ä", "&Auml;");
/*  77 */     hashMap.put("Å", "&Aring;");
/*  78 */     hashMap.put("Æ", "&AElig;");
/*  79 */     hashMap.put("Ç", "&Ccedil;");
/*  80 */     hashMap.put("È", "&Egrave;");
/*  81 */     hashMap.put("É", "&Eacute;");
/*  82 */     hashMap.put("Ê", "&Ecirc;");
/*  83 */     hashMap.put("Ë", "&Euml;");
/*  84 */     hashMap.put("Ì", "&Igrave;");
/*  85 */     hashMap.put("Í", "&Iacute;");
/*  86 */     hashMap.put("Î", "&Icirc;");
/*  87 */     hashMap.put("Ï", "&Iuml;");
/*  88 */     hashMap.put("Ð", "&ETH;");
/*  89 */     hashMap.put("Ñ", "&Ntilde;");
/*  90 */     hashMap.put("Ò", "&Ograve;");
/*  91 */     hashMap.put("Ó", "&Oacute;");
/*  92 */     hashMap.put("Ô", "&Ocirc;");
/*  93 */     hashMap.put("Õ", "&Otilde;");
/*  94 */     hashMap.put("Ö", "&Ouml;");
/*  95 */     hashMap.put("×", "&times;");
/*  96 */     hashMap.put("Ø", "&Oslash;");
/*  97 */     hashMap.put("Ù", "&Ugrave;");
/*  98 */     hashMap.put("Ú", "&Uacute;");
/*  99 */     hashMap.put("Û", "&Ucirc;");
/* 100 */     hashMap.put("Ü", "&Uuml;");
/* 101 */     hashMap.put("Ý", "&Yacute;");
/* 102 */     hashMap.put("Þ", "&THORN;");
/* 103 */     hashMap.put("ß", "&szlig;");
/* 104 */     hashMap.put("à", "&agrave;");
/* 105 */     hashMap.put("á", "&aacute;");
/* 106 */     hashMap.put("â", "&acirc;");
/* 107 */     hashMap.put("ã", "&atilde;");
/* 108 */     hashMap.put("ä", "&auml;");
/* 109 */     hashMap.put("å", "&aring;");
/* 110 */     hashMap.put("æ", "&aelig;");
/* 111 */     hashMap.put("ç", "&ccedil;");
/* 112 */     hashMap.put("è", "&egrave;");
/* 113 */     hashMap.put("é", "&eacute;");
/* 114 */     hashMap.put("ê", "&ecirc;");
/* 115 */     hashMap.put("ë", "&euml;");
/* 116 */     hashMap.put("ì", "&igrave;");
/* 117 */     hashMap.put("í", "&iacute;");
/* 118 */     hashMap.put("î", "&icirc;");
/* 119 */     hashMap.put("ï", "&iuml;");
/* 120 */     hashMap.put("ð", "&eth;");
/* 121 */     hashMap.put("ñ", "&ntilde;");
/* 122 */     hashMap.put("ò", "&ograve;");
/* 123 */     hashMap.put("ó", "&oacute;");
/* 124 */     hashMap.put("ô", "&ocirc;");
/* 125 */     hashMap.put("õ", "&otilde;");
/* 126 */     hashMap.put("ö", "&ouml;");
/* 127 */     hashMap.put("÷", "&divide;");
/* 128 */     hashMap.put("ø", "&oslash;");
/* 129 */     hashMap.put("ù", "&ugrave;");
/* 130 */     hashMap.put("ú", "&uacute;");
/* 131 */     hashMap.put("û", "&ucirc;");
/* 132 */     hashMap.put("ü", "&uuml;");
/* 133 */     hashMap.put("ý", "&yacute;");
/* 134 */     hashMap.put("þ", "&thorn;");
/* 135 */     hashMap.put("ÿ", "&yuml;");
/* 136 */     ISO8859_1_ESCAPE = Collections.unmodifiableMap(hashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 144 */   public static final Map<CharSequence, CharSequence> ISO8859_1_UNESCAPE = Collections.unmodifiableMap(invert(ISO8859_1_ESCAPE));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Map<CharSequence, CharSequence> HTML40_EXTENDED_ESCAPE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 155 */     hashMap = new HashMap<>();
/*     */     
/* 157 */     hashMap.put("ƒ", "&fnof;");
/*     */     
/* 159 */     hashMap.put("Α", "&Alpha;");
/* 160 */     hashMap.put("Β", "&Beta;");
/* 161 */     hashMap.put("Γ", "&Gamma;");
/* 162 */     hashMap.put("Δ", "&Delta;");
/* 163 */     hashMap.put("Ε", "&Epsilon;");
/* 164 */     hashMap.put("Ζ", "&Zeta;");
/* 165 */     hashMap.put("Η", "&Eta;");
/* 166 */     hashMap.put("Θ", "&Theta;");
/* 167 */     hashMap.put("Ι", "&Iota;");
/* 168 */     hashMap.put("Κ", "&Kappa;");
/* 169 */     hashMap.put("Λ", "&Lambda;");
/* 170 */     hashMap.put("Μ", "&Mu;");
/* 171 */     hashMap.put("Ν", "&Nu;");
/* 172 */     hashMap.put("Ξ", "&Xi;");
/* 173 */     hashMap.put("Ο", "&Omicron;");
/* 174 */     hashMap.put("Π", "&Pi;");
/* 175 */     hashMap.put("Ρ", "&Rho;");
/*     */     
/* 177 */     hashMap.put("Σ", "&Sigma;");
/* 178 */     hashMap.put("Τ", "&Tau;");
/* 179 */     hashMap.put("Υ", "&Upsilon;");
/* 180 */     hashMap.put("Φ", "&Phi;");
/* 181 */     hashMap.put("Χ", "&Chi;");
/* 182 */     hashMap.put("Ψ", "&Psi;");
/* 183 */     hashMap.put("Ω", "&Omega;");
/* 184 */     hashMap.put("α", "&alpha;");
/* 185 */     hashMap.put("β", "&beta;");
/* 186 */     hashMap.put("γ", "&gamma;");
/* 187 */     hashMap.put("δ", "&delta;");
/* 188 */     hashMap.put("ε", "&epsilon;");
/* 189 */     hashMap.put("ζ", "&zeta;");
/* 190 */     hashMap.put("η", "&eta;");
/* 191 */     hashMap.put("θ", "&theta;");
/* 192 */     hashMap.put("ι", "&iota;");
/* 193 */     hashMap.put("κ", "&kappa;");
/* 194 */     hashMap.put("λ", "&lambda;");
/* 195 */     hashMap.put("μ", "&mu;");
/* 196 */     hashMap.put("ν", "&nu;");
/* 197 */     hashMap.put("ξ", "&xi;");
/* 198 */     hashMap.put("ο", "&omicron;");
/* 199 */     hashMap.put("π", "&pi;");
/* 200 */     hashMap.put("ρ", "&rho;");
/* 201 */     hashMap.put("ς", "&sigmaf;");
/* 202 */     hashMap.put("σ", "&sigma;");
/* 203 */     hashMap.put("τ", "&tau;");
/* 204 */     hashMap.put("υ", "&upsilon;");
/* 205 */     hashMap.put("φ", "&phi;");
/* 206 */     hashMap.put("χ", "&chi;");
/* 207 */     hashMap.put("ψ", "&psi;");
/* 208 */     hashMap.put("ω", "&omega;");
/* 209 */     hashMap.put("ϑ", "&thetasym;");
/* 210 */     hashMap.put("ϒ", "&upsih;");
/* 211 */     hashMap.put("ϖ", "&piv;");
/*     */     
/* 213 */     hashMap.put("•", "&bull;");
/*     */     
/* 215 */     hashMap.put("…", "&hellip;");
/* 216 */     hashMap.put("′", "&prime;");
/* 217 */     hashMap.put("″", "&Prime;");
/* 218 */     hashMap.put("‾", "&oline;");
/* 219 */     hashMap.put("⁄", "&frasl;");
/*     */     
/* 221 */     hashMap.put("℘", "&weierp;");
/* 222 */     hashMap.put("ℑ", "&image;");
/* 223 */     hashMap.put("ℜ", "&real;");
/* 224 */     hashMap.put("™", "&trade;");
/* 225 */     hashMap.put("ℵ", "&alefsym;");
/*     */ 
/*     */ 
/*     */     
/* 229 */     hashMap.put("←", "&larr;");
/* 230 */     hashMap.put("↑", "&uarr;");
/* 231 */     hashMap.put("→", "&rarr;");
/* 232 */     hashMap.put("↓", "&darr;");
/* 233 */     hashMap.put("↔", "&harr;");
/* 234 */     hashMap.put("↵", "&crarr;");
/* 235 */     hashMap.put("⇐", "&lArr;");
/*     */ 
/*     */ 
/*     */     
/* 239 */     hashMap.put("⇑", "&uArr;");
/* 240 */     hashMap.put("⇒", "&rArr;");
/*     */ 
/*     */ 
/*     */     
/* 244 */     hashMap.put("⇓", "&dArr;");
/* 245 */     hashMap.put("⇔", "&hArr;");
/*     */     
/* 247 */     hashMap.put("∀", "&forall;");
/* 248 */     hashMap.put("∂", "&part;");
/* 249 */     hashMap.put("∃", "&exist;");
/* 250 */     hashMap.put("∅", "&empty;");
/* 251 */     hashMap.put("∇", "&nabla;");
/* 252 */     hashMap.put("∈", "&isin;");
/* 253 */     hashMap.put("∉", "&notin;");
/* 254 */     hashMap.put("∋", "&ni;");
/*     */     
/* 256 */     hashMap.put("∏", "&prod;");
/*     */ 
/*     */     
/* 259 */     hashMap.put("∑", "&sum;");
/*     */ 
/*     */     
/* 262 */     hashMap.put("−", "&minus;");
/* 263 */     hashMap.put("∗", "&lowast;");
/* 264 */     hashMap.put("√", "&radic;");
/* 265 */     hashMap.put("∝", "&prop;");
/* 266 */     hashMap.put("∞", "&infin;");
/* 267 */     hashMap.put("∠", "&ang;");
/* 268 */     hashMap.put("∧", "&and;");
/* 269 */     hashMap.put("∨", "&or;");
/* 270 */     hashMap.put("∩", "&cap;");
/* 271 */     hashMap.put("∪", "&cup;");
/* 272 */     hashMap.put("∫", "&int;");
/* 273 */     hashMap.put("∴", "&there4;");
/* 274 */     hashMap.put("∼", "&sim;");
/*     */ 
/*     */     
/* 277 */     hashMap.put("≅", "&cong;");
/* 278 */     hashMap.put("≈", "&asymp;");
/* 279 */     hashMap.put("≠", "&ne;");
/* 280 */     hashMap.put("≡", "&equiv;");
/* 281 */     hashMap.put("≤", "&le;");
/* 282 */     hashMap.put("≥", "&ge;");
/* 283 */     hashMap.put("⊂", "&sub;");
/* 284 */     hashMap.put("⊃", "&sup;");
/*     */ 
/*     */ 
/*     */     
/* 288 */     hashMap.put("⊄", "&nsub;");
/* 289 */     hashMap.put("⊆", "&sube;");
/* 290 */     hashMap.put("⊇", "&supe;");
/* 291 */     hashMap.put("⊕", "&oplus;");
/* 292 */     hashMap.put("⊗", "&otimes;");
/* 293 */     hashMap.put("⊥", "&perp;");
/* 294 */     hashMap.put("⋅", "&sdot;");
/*     */ 
/*     */     
/* 297 */     hashMap.put("⌈", "&lceil;");
/* 298 */     hashMap.put("⌉", "&rceil;");
/* 299 */     hashMap.put("⌊", "&lfloor;");
/* 300 */     hashMap.put("⌋", "&rfloor;");
/* 301 */     hashMap.put("〈", "&lang;");
/*     */ 
/*     */     
/* 304 */     hashMap.put("〉", "&rang;");
/*     */ 
/*     */ 
/*     */     
/* 308 */     hashMap.put("◊", "&loz;");
/*     */     
/* 310 */     hashMap.put("♠", "&spades;");
/*     */     
/* 312 */     hashMap.put("♣", "&clubs;");
/* 313 */     hashMap.put("♥", "&hearts;");
/* 314 */     hashMap.put("♦", "&diams;");
/*     */ 
/*     */     
/* 317 */     hashMap.put("Œ", "&OElig;");
/* 318 */     hashMap.put("œ", "&oelig;");
/*     */     
/* 320 */     hashMap.put("Š", "&Scaron;");
/* 321 */     hashMap.put("š", "&scaron;");
/* 322 */     hashMap.put("Ÿ", "&Yuml;");
/*     */     
/* 324 */     hashMap.put("ˆ", "&circ;");
/* 325 */     hashMap.put("˜", "&tilde;");
/*     */     
/* 327 */     hashMap.put(" ", "&ensp;");
/* 328 */     hashMap.put(" ", "&emsp;");
/* 329 */     hashMap.put(" ", "&thinsp;");
/* 330 */     hashMap.put("‌", "&zwnj;");
/* 331 */     hashMap.put("‍", "&zwj;");
/* 332 */     hashMap.put("‎", "&lrm;");
/* 333 */     hashMap.put("‏", "&rlm;");
/* 334 */     hashMap.put("–", "&ndash;");
/* 335 */     hashMap.put("—", "&mdash;");
/* 336 */     hashMap.put("‘", "&lsquo;");
/* 337 */     hashMap.put("’", "&rsquo;");
/* 338 */     hashMap.put("‚", "&sbquo;");
/* 339 */     hashMap.put("“", "&ldquo;");
/* 340 */     hashMap.put("”", "&rdquo;");
/* 341 */     hashMap.put("„", "&bdquo;");
/* 342 */     hashMap.put("†", "&dagger;");
/* 343 */     hashMap.put("‡", "&Dagger;");
/* 344 */     hashMap.put("‰", "&permil;");
/* 345 */     hashMap.put("‹", "&lsaquo;");
/*     */     
/* 347 */     hashMap.put("›", "&rsaquo;");
/*     */     
/* 349 */     hashMap.put("€", "&euro;");
/* 350 */     HTML40_EXTENDED_ESCAPE = Collections.unmodifiableMap(hashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 358 */   public static final Map<CharSequence, CharSequence> HTML40_EXTENDED_UNESCAPE = Collections.unmodifiableMap(invert(HTML40_EXTENDED_ESCAPE));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Map<CharSequence, CharSequence> BASIC_ESCAPE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 369 */     hashMap = new HashMap<>();
/* 370 */     hashMap.put("\"", "&quot;");
/* 371 */     hashMap.put("&", "&amp;");
/* 372 */     hashMap.put("<", "&lt;");
/* 373 */     hashMap.put(">", "&gt;");
/* 374 */     BASIC_ESCAPE = Collections.unmodifiableMap(hashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 382 */   public static final Map<CharSequence, CharSequence> BASIC_UNESCAPE = Collections.unmodifiableMap(invert(BASIC_ESCAPE));
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Map<CharSequence, CharSequence> APOS_ESCAPE;
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 391 */     hashMap = new HashMap<>();
/* 392 */     hashMap.put("'", "&apos;");
/* 393 */     APOS_ESCAPE = Collections.unmodifiableMap(hashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 401 */   public static final Map<CharSequence, CharSequence> APOS_UNESCAPE = Collections.unmodifiableMap(invert(APOS_ESCAPE));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Map<CharSequence, CharSequence> JAVA_CTRL_CHARS_ESCAPE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 412 */     hashMap = new HashMap<>();
/* 413 */     hashMap.put("\b", "\\b");
/* 414 */     hashMap.put("\n", "\\n");
/* 415 */     hashMap.put("\t", "\\t");
/* 416 */     hashMap.put("\f", "\\f");
/* 417 */     hashMap.put("\r", "\\r");
/* 418 */     JAVA_CTRL_CHARS_ESCAPE = Collections.unmodifiableMap(hashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 426 */   public static final Map<CharSequence, CharSequence> JAVA_CTRL_CHARS_UNESCAPE = Collections.unmodifiableMap(invert(JAVA_CTRL_CHARS_ESCAPE));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<CharSequence, CharSequence> invert(Map<CharSequence, CharSequence> paramMap) {
/* 435 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 436 */     for (Map.Entry<CharSequence, CharSequence> entry : paramMap.entrySet()) {
/* 437 */       hashMap.put(entry.getValue(), entry.getKey());
/*     */     }
/* 439 */     return (Map)hashMap;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\EntityArrays.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */