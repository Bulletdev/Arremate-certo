/*     */ package org.apache.xmlbeans.impl.regex;
/*     */ 
/*     */ import java.util.Hashtable;
/*     */ import java.util.Locale;
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
/*     */ class ParserForXMLSchema
/*     */   extends RegexParser
/*     */ {
/*     */   public ParserForXMLSchema() {}
/*     */   
/*     */   public ParserForXMLSchema(Locale paramLocale) {}
/*     */   
/*     */   Token processCaret() throws ParseException {
/*  36 */     next();
/*  37 */     return Token.createChar(94);
/*     */   }
/*     */   Token processDollar() throws ParseException {
/*  40 */     next();
/*  41 */     return Token.createChar(36);
/*     */   }
/*     */   Token processLookahead() throws ParseException {
/*  44 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processNegativelookahead() throws ParseException {
/*  47 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processLookbehind() throws ParseException {
/*  50 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processNegativelookbehind() throws ParseException {
/*  53 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processBacksolidus_A() throws ParseException {
/*  56 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processBacksolidus_Z() throws ParseException {
/*  59 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processBacksolidus_z() throws ParseException {
/*  62 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processBacksolidus_b() throws ParseException {
/*  65 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processBacksolidus_B() throws ParseException {
/*  68 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processBacksolidus_lt() throws ParseException {
/*  71 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processBacksolidus_gt() throws ParseException {
/*  74 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processStar(Token paramToken) throws ParseException {
/*  77 */     next();
/*  78 */     return Token.createClosure(paramToken);
/*     */   }
/*     */   
/*     */   Token processPlus(Token paramToken) throws ParseException {
/*  82 */     next();
/*  83 */     return Token.createConcat(paramToken, Token.createClosure(paramToken));
/*     */   }
/*     */   
/*     */   Token processQuestion(Token paramToken) throws ParseException {
/*  87 */     next();
/*  88 */     Token.UnionToken unionToken = Token.createUnion();
/*  89 */     unionToken.addChild(paramToken);
/*  90 */     unionToken.addChild(Token.createEmpty());
/*  91 */     return unionToken;
/*     */   }
/*     */   boolean checkQuestion(int paramInt) {
/*  94 */     return false;
/*     */   }
/*     */   Token processParen() throws ParseException {
/*  97 */     next();
/*  98 */     Token.ParenToken parenToken = Token.createParen(parseRegex(), 0);
/*  99 */     if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/* 100 */     next();
/* 101 */     return parenToken;
/*     */   }
/*     */   Token processParen2() throws ParseException {
/* 104 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processCondition() throws ParseException {
/* 107 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processModifiers() throws ParseException {
/* 110 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processIndependent() throws ParseException {
/* 113 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   Token processBacksolidus_c() throws ParseException {
/* 116 */     next();
/* 117 */     return getTokenForShorthand(99);
/*     */   }
/*     */   Token processBacksolidus_C() throws ParseException {
/* 120 */     next();
/* 121 */     return getTokenForShorthand(67);
/*     */   }
/*     */   Token processBacksolidus_i() throws ParseException {
/* 124 */     next();
/* 125 */     return getTokenForShorthand(105);
/*     */   }
/*     */   Token processBacksolidus_I() throws ParseException {
/* 128 */     next();
/* 129 */     return getTokenForShorthand(73);
/*     */   }
/*     */   Token processBacksolidus_g() throws ParseException {
/* 132 */     throw ex("parser.process.1", this.offset - 2);
/*     */   }
/*     */   Token processBacksolidus_X() throws ParseException {
/* 135 */     throw ex("parser.process.1", this.offset - 2);
/*     */   }
/*     */   Token processBackreference() throws ParseException {
/* 138 */     throw ex("parser.process.1", this.offset - 4);
/*     */   }
/*     */   
/*     */   int processCIinCharacterClass(RangeToken paramRangeToken, int paramInt) {
/* 142 */     paramRangeToken.mergeRanges(getTokenForShorthand(paramInt));
/* 143 */     return -1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected RangeToken parseCharacterClass(boolean paramBoolean) throws ParseException {
/*     */     RangeToken rangeToken2;
/* 165 */     setContext(1);
/* 166 */     next();
/* 167 */     boolean bool1 = false;
/* 168 */     RangeToken rangeToken1 = null;
/*     */     
/* 170 */     if (read() == 0 && this.chardata == 94) {
/* 171 */       bool1 = true;
/* 172 */       next();
/* 173 */       rangeToken1 = Token.createRange();
/* 174 */       rangeToken1.addRange(0, 1114111);
/* 175 */       rangeToken2 = Token.createRange();
/*     */     } else {
/* 177 */       rangeToken2 = Token.createRange();
/*     */     } 
/*     */     
/* 180 */     boolean bool2 = true; int i;
/* 181 */     while ((i = read()) != 1) {
/*     */       
/* 183 */       if (i == 0 && this.chardata == 93 && !bool2) {
/* 184 */         if (bool1) {
/* 185 */           rangeToken1.subtractRanges(rangeToken2);
/* 186 */           rangeToken2 = rangeToken1;
/*     */         } 
/*     */         break;
/*     */       } 
/* 190 */       int j = this.chardata;
/* 191 */       boolean bool = false;
/* 192 */       if (i == 10) {
/* 193 */         int k; RangeToken rangeToken; switch (j) { case 68: case 83: case 87:
/*     */           case 100:
/*     */           case 115:
/*     */           case 119:
/* 197 */             rangeToken2.mergeRanges(getTokenForShorthand(j));
/* 198 */             bool = true; break;
/*     */           case 67:
/*     */           case 73:
/*     */           case 99:
/*     */           case 105:
/* 203 */             j = processCIinCharacterClass(rangeToken2, j);
/* 204 */             if (j < 0) bool = true;
/*     */             
/*     */             break;
/*     */           case 80:
/*     */           case 112:
/* 209 */             k = this.offset;
/* 210 */             rangeToken = processBacksolidus_pP(j);
/* 211 */             if (rangeToken == null) throw ex("parser.atom.5", k); 
/* 212 */             rangeToken2.mergeRanges(rangeToken);
/* 213 */             bool = true;
/*     */             break;
/*     */           
/*     */           default:
/* 217 */             j = decodeEscaped();
/*     */             break; }
/*     */       
/* 220 */       } else if (i == 24 && !bool2) {
/*     */         
/* 222 */         if (bool1) {
/* 223 */           rangeToken1.subtractRanges(rangeToken2);
/* 224 */           rangeToken2 = rangeToken1;
/*     */         } 
/* 226 */         RangeToken rangeToken = parseCharacterClass(false);
/* 227 */         rangeToken2.subtractRanges(rangeToken);
/* 228 */         if (read() != 0 || this.chardata != 93)
/* 229 */           throw ex("parser.cc.5", this.offset); 
/*     */         break;
/*     */       } 
/* 232 */       next();
/* 233 */       if (!bool) {
/* 234 */         if (i == 0) {
/* 235 */           if (j == 91) throw ex("parser.cc.6", this.offset - 2); 
/* 236 */           if (j == 93) throw ex("parser.cc.7", this.offset - 2);
/*     */ 
/*     */           
/* 239 */           if (j == 45 && !bool2 && this.chardata != 93) throw ex("parser.cc.8", this.offset - 2); 
/*     */         } 
/* 241 */         if (read() != 0 || this.chardata != 45) {
/* 242 */           rangeToken2.addRange(j, j);
/*     */         } else {
/*     */           
/* 245 */           next();
/* 246 */           if ((i = read()) == 1) throw ex("parser.cc.2", this.offset);
/*     */           
/* 248 */           if (i == 24)
/* 249 */             throw ex("parser.cc.8", this.offset - 1); 
/* 250 */           if (i == 0 && this.chardata == 93) {
/*     */             
/* 252 */             rangeToken2.addRange(j, j);
/* 253 */             rangeToken2.addRange(45, 45);
/*     */           } else {
/* 255 */             int k = this.chardata;
/* 256 */             if (i == 0) {
/* 257 */               if (k == 91) throw ex("parser.cc.6", this.offset - 1); 
/* 258 */               if (k == 93) throw ex("parser.cc.7", this.offset - 1); 
/* 259 */               if (k == 45) {
/* 260 */                 next();
/* 261 */                 if (this.chardata != 93) {
/* 262 */                   throw ex("parser.cc.8", this.offset - 2);
/*     */                 }
/*     */               } 
/* 265 */             } else if (i == 10) {
/* 266 */               k = decodeEscaped();
/* 267 */             }  if (k != 45 || this.chardata != 93) {
/* 268 */               next();
/*     */             }
/* 270 */             if (j > k) throw ex("parser.ope.3", this.offset - 1); 
/* 271 */             rangeToken2.addRange(j, k);
/*     */           } 
/*     */         } 
/*     */       } 
/* 275 */       bool2 = false;
/*     */     } 
/* 277 */     if (read() == 1)
/* 278 */       throw ex("parser.cc.2", this.offset); 
/* 279 */     rangeToken2.sortRanges();
/* 280 */     rangeToken2.compactRanges();
/*     */     
/* 282 */     setContext(0);
/* 283 */     next();
/*     */     
/* 285 */     return rangeToken2;
/*     */   }
/*     */   
/*     */   protected RangeToken parseSetOperations() throws ParseException {
/* 289 */     throw ex("parser.process.1", this.offset);
/*     */   }
/*     */   
/*     */   Token getTokenForShorthand(int paramInt) {
/* 293 */     switch (paramInt) {
/*     */       case 100:
/* 295 */         return getRange("xml:isDigit", true);
/*     */       case 68:
/* 297 */         return getRange("xml:isDigit", false);
/*     */       case 119:
/* 299 */         return getRange("xml:isWord", true);
/*     */       case 87:
/* 301 */         return getRange("xml:isWord", false);
/*     */       case 115:
/* 303 */         return getRange("xml:isSpace", true);
/*     */       case 83:
/* 305 */         return getRange("xml:isSpace", false);
/*     */       case 99:
/* 307 */         return getRange("xml:isNameChar", true);
/*     */       case 67:
/* 309 */         return getRange("xml:isNameChar", false);
/*     */       case 105:
/* 311 */         return getRange("xml:isInitialNameChar", true);
/*     */       case 73:
/* 313 */         return getRange("xml:isInitialNameChar", false);
/*     */     } 
/* 315 */     throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(paramInt, 16));
/*     */   }
/*     */   
/*     */   int decodeEscaped() throws ParseException {
/* 319 */     if (read() != 10) throw ex("parser.next.1", this.offset - 1); 
/* 320 */     int i = this.chardata;
/* 321 */     switch (i) { case 110:
/* 322 */         i = 10;
/* 323 */       case 114: i = 13;
/* 324 */       case 116: i = 9;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 40:
/*     */       case 41:
/*     */       case 42:
/*     */       case 43:
/*     */       case 45:
/*     */       case 46:
/*     */       case 63:
/*     */       case 91:
/*     */       case 92:
/*     */       case 93:
/*     */       case 94:
/*     */       case 123:
/*     */       case 124:
/*     */       case 125:
/* 343 */         return i; }
/*     */     
/*     */     throw ex("parser.process.1", this.offset - 2);
/* 346 */   } private static Hashtable ranges = null;
/* 347 */   private static Hashtable ranges2 = null; private static final String SPACES = "\t\n\r\r  "; private static final String NAMECHARS = "-.0:AZ__az··ÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁːˑ̀͠͡ͅΆΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁ҃҆ҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆֹֻֽֿֿׁׂ֑֣֡ׄׄאתװײءغـْ٠٩ٰڷںھۀێېۓە۪ۭۨ۰۹ँःअह़्॑॔क़ॣ०९ঁঃঅঌএঐওনপরললশহ়়াৄেৈো্ৗৗড়ঢ়য়ৣ০ৱਂਂਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹ਼਼ਾੂੇੈੋ੍ਖ਼ੜਫ਼ਫ਼੦ੴઁઃઅઋઍઍએઑઓનપરલળવહ઼ૅેૉો્ૠૠ૦૯ଁଃଅଌଏଐଓନପରଲଳଶହ଼ୃେୈୋ୍ୖୗଡ଼ଢ଼ୟୡ୦୯ஂஃஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹாூெைொ்ௗௗ௧௯ఁఃఅఌఎఐఒనపళవహాౄెైొ్ౕౖౠౡ౦౯ಂಃಅಌಎಐಒನಪಳವಹಾೄೆೈೊ್ೕೖೞೞೠೡ೦೯ംഃഅഌഎഐഒനപഹാൃെൈൊ്ൗൗൠൡ൦൯กฮะฺเ๎๐๙ກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະູົຽເໄໆໆ່ໍ໐໙༘༙༠༩༹༹༵༵༷༷༾ཇཉཀྵ྄ཱ྆ྋྐྕྗྗྙྭྱྷྐྵྐྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼ⃐⃜⃡⃡ΩΩKÅ℮℮ↀↂ々々〇〇〡〯〱〵ぁゔ゙゚ゝゞァヺーヾㄅㄬ一龥가힣";
/*     */   protected static synchronized RangeToken getRange(String paramString, boolean paramBoolean) {
/* 349 */     if (ranges == null) {
/* 350 */       ranges = new Hashtable();
/* 351 */       ranges2 = new Hashtable();
/*     */       
/* 353 */       RangeToken rangeToken = Token.createRange();
/* 354 */       setupRange(rangeToken, "\t\n\r\r  ");
/* 355 */       ranges.put("xml:isSpace", rangeToken);
/* 356 */       ranges2.put("xml:isSpace", Token.complementRanges(rangeToken));
/*     */       
/* 358 */       rangeToken = Token.createRange();
/* 359 */       setupRange(rangeToken, "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩");
/* 360 */       ranges.put("xml:isDigit", rangeToken);
/* 361 */       ranges2.put("xml:isDigit", Token.complementRanges(rangeToken));
/*     */       
/* 363 */       rangeToken = Token.createRange();
/* 364 */       setupRange(rangeToken, "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩");
/* 365 */       ranges.put("xml:isDigit", rangeToken);
/* 366 */       ranges2.put("xml:isDigit", Token.complementRanges(rangeToken));
/*     */       
/* 368 */       rangeToken = Token.createRange();
/* 369 */       setupRange(rangeToken, "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣");
/* 370 */       rangeToken.mergeRanges((Token)ranges.get("xml:isDigit"));
/* 371 */       ranges.put("xml:isWord", rangeToken);
/* 372 */       ranges2.put("xml:isWord", Token.complementRanges(rangeToken));
/*     */       
/* 374 */       rangeToken = Token.createRange();
/* 375 */       setupRange(rangeToken, "-.0:AZ__az··ÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁːˑ̀͠͡ͅΆΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁ҃҆ҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆֹֻֽֿֿׁׂ֑֣֡ׄׄאתװײءغـْ٠٩ٰڷںھۀێېۓە۪ۭۨ۰۹ँःअह़्॑॔क़ॣ०९ঁঃঅঌএঐওনপরললশহ়়াৄেৈো্ৗৗড়ঢ়য়ৣ০ৱਂਂਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹ਼਼ਾੂੇੈੋ੍ਖ਼ੜਫ਼ਫ਼੦ੴઁઃઅઋઍઍએઑઓનપરલળવહ઼ૅેૉો્ૠૠ૦૯ଁଃଅଌଏଐଓନପରଲଳଶହ଼ୃେୈୋ୍ୖୗଡ଼ଢ଼ୟୡ୦୯ஂஃஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹாூெைொ்ௗௗ௧௯ఁఃఅఌఎఐఒనపళవహాౄెైొ్ౕౖౠౡ౦౯ಂಃಅಌಎಐಒನಪಳವಹಾೄೆೈೊ್ೕೖೞೞೠೡ೦೯ംഃഅഌഎഐഒനപഹാൃെൈൊ്ൗൗൠൡ൦൯กฮะฺเ๎๐๙ກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະູົຽເໄໆໆ່ໍ໐໙༘༙༠༩༹༹༵༵༷༷༾ཇཉཀྵ྄ཱ྆ྋྐྕྗྗྙྭྱྷྐྵྐྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼ⃐⃜⃡⃡ΩΩKÅ℮℮ↀↂ々々〇〇〡〯〱〵ぁゔ゙゚ゝゞァヺーヾㄅㄬ一龥가힣");
/* 376 */       ranges.put("xml:isNameChar", rangeToken);
/* 377 */       ranges2.put("xml:isNameChar", Token.complementRanges(rangeToken));
/*     */       
/* 379 */       rangeToken = Token.createRange();
/* 380 */       setupRange(rangeToken, "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣");
/* 381 */       rangeToken.addRange(95, 95);
/* 382 */       rangeToken.addRange(58, 58);
/* 383 */       ranges.put("xml:isInitialNameChar", rangeToken);
/* 384 */       ranges2.put("xml:isInitialNameChar", Token.complementRanges(rangeToken));
/*     */     } 
/* 386 */     return paramBoolean ? (RangeToken)ranges.get(paramString) : (RangeToken)ranges2.get(paramString);
/*     */   }
/*     */   private static final String LETTERS = "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣";
/*     */   private static final String DIGITS = "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩";
/*     */   
/*     */   static void setupRange(Token paramToken, String paramString) {
/* 392 */     int i = paramString.length();
/* 393 */     for (byte b = 0; b < i; b += 2)
/* 394 */       paramToken.addRange(paramString.charAt(b), paramString.charAt(b + 1)); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\ParserForXMLSchema.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */