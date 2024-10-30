/*      */ package org.apache.xmlbeans.impl.regex;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.util.Hashtable;
/*      */ import java.util.Vector;
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
/*      */ class Token
/*      */   implements Serializable
/*      */ {
/*      */   static final boolean COUNTTOKENS = true;
/*   26 */   static int tokens = 0;
/*      */   
/*      */   static final int CHAR = 0;
/*      */   
/*      */   static final int DOT = 11;
/*      */   
/*      */   static final int CONCAT = 1;
/*      */   
/*      */   static final int UNION = 2;
/*      */   
/*      */   static final int CLOSURE = 3;
/*      */   
/*      */   static final int RANGE = 4;
/*      */   
/*      */   static final int NRANGE = 5;
/*      */   
/*      */   static final int PAREN = 6;
/*      */   
/*      */   static final int EMPTY = 7;
/*      */   
/*      */   static final int ANCHOR = 8;
/*      */   
/*      */   static final int NONGREEDYCLOSURE = 9;
/*      */   
/*      */   static final int STRING = 10;
/*      */   
/*      */   static final int BACKREFERENCE = 12;
/*      */   
/*      */   static final int LOOKAHEAD = 20;
/*      */   
/*      */   static final int NEGATIVELOOKAHEAD = 21;
/*      */   
/*      */   static final int LOOKBEHIND = 22;
/*      */   static final int NEGATIVELOOKBEHIND = 23;
/*      */   static final int INDEPENDENT = 24;
/*      */   static final int MODIFIERGROUP = 25;
/*      */   static final int CONDITION = 26;
/*      */   static final int UTF16_MAX = 1114111;
/*      */   int type;
/*      */   static Token token_dot;
/*      */   static Token token_0to9;
/*      */   static Token token_wordchars;
/*      */   static Token token_not_0to9;
/*      */   static Token token_not_wordchars;
/*      */   static Token token_spaces;
/*      */   static Token token_not_spaces;
/*   72 */   static Token token_empty = new Token(7);
/*      */   
/*   74 */   static Token token_linebeginning = createAnchor(94);
/*   75 */   static Token token_linebeginning2 = createAnchor(64);
/*   76 */   static Token token_lineend = createAnchor(36);
/*   77 */   static Token token_stringbeginning = createAnchor(65);
/*   78 */   static Token token_stringend = createAnchor(122);
/*   79 */   static Token token_stringend2 = createAnchor(90);
/*   80 */   static Token token_wordedge = createAnchor(98);
/*   81 */   static Token token_not_wordedge = createAnchor(66);
/*   82 */   static Token token_wordbeginning = createAnchor(60);
/*   83 */   static Token token_wordend = createAnchor(62); static final int FC_CONTINUE = 0; static final int FC_TERMINAL = 1; static final int FC_ANY = 2; private static final Hashtable categories; private static final Hashtable categories2; private static final String[] categoryNames; static final int CHAR_INIT_QUOTE = 29; static final int CHAR_FINAL_QUOTE = 30; static final int CHAR_LETTER = 31; static final int CHAR_MARK = 32; static final int CHAR_NUMBER = 33; static final int CHAR_SEPARATOR = 34; static final int CHAR_OTHER = 35; static final int CHAR_PUNCTUATION = 36; static final int CHAR_SYMBOL = 37; private static final String[] blockNames; static final String blockRanges = "\000ÿĀſƀɏɐʯʰ˿̀ͯͰϿЀӿ԰֏֐׿؀ۿ܀ݏހ޿ऀॿঀ৿਀੿઀૿଀୿஀௿ఀ౿ಀ೿ഀൿ඀෿฀๿຀໿ༀ࿿က႟Ⴀჿᄀᇿሀ፿Ꭰ᏿᐀ᙿ ᚟ᚠ᛿ក៿᠀᢯Ḁỿἀ῿ ⁯⁰₟₠⃏⃐⃿℀⅏⅐↏←⇿∀⋿⌀⏿␀␿⑀⑟①⓿─╿▀▟■◿☀⛿✀➿⠀⣿⺀⻿⼀⿟⿰⿿　〿぀ゟ゠ヿ㄀ㄯ㄰㆏㆐㆟ㆠㆿ㈀㋿㌀㏿㐀䶵一鿿ꀀ꒏꒐꓏가힣豈﫿ﬀﭏﭐ﷿︠︯︰﹏﹐﹯ﹰ﻾﻿﻿＀￯"; static final int[] nonBMPBlockRanges; private static final int NONBMP_BLOCK_START = 84; static Hashtable nonxs; static final String viramaString = "्্੍્୍்్್്ฺ྄"; private static Token token_grapheme; private static Token token_ccs;
/*      */   
/*   85 */   static { token_dot = new Token(11);
/*      */     
/*   87 */     token_0to9 = createRange();
/*   88 */     token_0to9.addRange(48, 57);
/*   89 */     token_wordchars = createRange();
/*   90 */     token_wordchars.addRange(48, 57);
/*   91 */     token_wordchars.addRange(65, 90);
/*   92 */     token_wordchars.addRange(95, 95);
/*   93 */     token_wordchars.addRange(97, 122);
/*   94 */     token_spaces = createRange();
/*   95 */     token_spaces.addRange(9, 9);
/*   96 */     token_spaces.addRange(10, 10);
/*   97 */     token_spaces.addRange(12, 12);
/*   98 */     token_spaces.addRange(13, 13);
/*   99 */     token_spaces.addRange(32, 32);
/*      */     
/*  101 */     token_not_0to9 = complementRanges(token_0to9);
/*  102 */     token_not_wordchars = complementRanges(token_wordchars);
/*  103 */     token_not_spaces = complementRanges(token_spaces);
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
/*  594 */     categories = new Hashtable();
/*  595 */     categories2 = new Hashtable();
/*  596 */     categoryNames = new String[] { "Cn", "Lu", "Ll", "Lt", "Lm", "Lo", "Mn", "Me", "Mc", "Nd", "Nl", "No", "Zs", "Zl", "Zp", "Cc", "Cf", null, "Co", "Cs", "Pd", "Ps", "Pe", "Pc", "Po", "Sm", "Sc", "Sk", "So", "Pi", "Pf", "L", "M", "N", "Z", "C", "P", "S" };
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
/*  616 */     blockNames = new String[] { "Basic Latin", "Latin-1 Supplement", "Latin Extended-A", "Latin Extended-B", "IPA Extensions", "Spacing Modifier Letters", "Combining Diacritical Marks", "Greek", "Cyrillic", "Armenian", "Hebrew", "Arabic", "Syriac", "Thaana", "Devanagari", "Bengali", "Gurmukhi", "Gujarati", "Oriya", "Tamil", "Telugu", "Kannada", "Malayalam", "Sinhala", "Thai", "Lao", "Tibetan", "Myanmar", "Georgian", "Hangul Jamo", "Ethiopic", "Cherokee", "Unified Canadian Aboriginal Syllabics", "Ogham", "Runic", "Khmer", "Mongolian", "Latin Extended Additional", "Greek Extended", "General Punctuation", "Superscripts and Subscripts", "Currency Symbols", "Combining Marks for Symbols", "Letterlike Symbols", "Number Forms", "Arrows", "Mathematical Operators", "Miscellaneous Technical", "Control Pictures", "Optical Character Recognition", "Enclosed Alphanumerics", "Box Drawing", "Block Elements", "Geometric Shapes", "Miscellaneous Symbols", "Dingbats", "Braille Patterns", "CJK Radicals Supplement", "Kangxi Radicals", "Ideographic Description Characters", "CJK Symbols and Punctuation", "Hiragana", "Katakana", "Bopomofo", "Hangul Compatibility Jamo", "Kanbun", "Bopomofo Extended", "Enclosed CJK Letters and Months", "CJK Compatibility", "CJK Unified Ideographs Extension A", "CJK Unified Ideographs", "Yi Syllables", "Yi Radicals", "Hangul Syllables", "Private Use", "CJK Compatibility Ideographs", "Alphabetic Presentation Forms", "Arabic Presentation Forms-A", "Combining Half Marks", "CJK Compatibility Forms", "Small Form Variants", "Arabic Presentation Forms-B", "Specials", "Halfwidth and Fullwidth Forms", "Old Italic", "Gothic", "Deseret", "Byzantine Musical Symbols", "Musical Symbols", "Mathematical Alphanumeric Symbols", "CJK Unified Ideographs Extension B", "CJK Compatibility Ideographs Supplement", "Tags" };
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
/*  730 */     nonBMPBlockRanges = new int[] { 66304, 66351, 66352, 66383, 66560, 66639, 118784, 119039, 119040, 119295, 119808, 120831, 131072, 173782, 194560, 195103, 917504, 917631 };
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  983 */     nonxs = null;
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
/* 1028 */     token_grapheme = null;
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
/* 1068 */     token_ccs = null; } static ParenToken createLook(int paramInt, Token paramToken) { tokens++; return new ParenToken(paramInt, paramToken, 0); } static ParenToken createParen(Token paramToken, int paramInt) { tokens++; return new ParenToken(6, paramToken, paramInt); } static ClosureToken createClosure(Token paramToken) { tokens++; return new ClosureToken(3, paramToken); } static ClosureToken createNGClosure(Token paramToken) { tokens++; return new ClosureToken(9, paramToken); } static ConcatToken createConcat(Token paramToken1, Token paramToken2) { tokens++; return new ConcatToken(paramToken1, paramToken2); } static UnionToken createConcat() { tokens++; return new UnionToken(1); } static UnionToken createUnion() { tokens++; return new UnionToken(2); } static Token createEmpty() { return token_empty; } static RangeToken createRange() { tokens++; return new RangeToken(4); } static RangeToken createNRange() { tokens++; return new RangeToken(5); } static CharToken createChar(int paramInt) { tokens++; return new CharToken(0, paramInt); } private static CharToken createAnchor(int paramInt) { tokens++; return new CharToken(8, paramInt); } static StringToken createBackReference(int paramInt) { tokens++; return new StringToken(12, null, paramInt); } static StringToken createString(String paramString) { tokens++; return new StringToken(10, paramString, 0); } static ModifierToken createModifierGroup(Token paramToken, int paramInt1, int paramInt2) { tokens++; return new ModifierToken(paramToken, paramInt1, paramInt2); } static ConditionToken createCondition(int paramInt, Token paramToken1, Token paramToken2, Token paramToken3) { tokens++; return new ConditionToken(paramInt, paramToken1, paramToken2, paramToken3); } protected Token(int paramInt) { this.type = paramInt; } int size() { return 0; } Token getChild(int paramInt) { return null; } void addChild(Token paramToken) { throw new RuntimeException("Not supported."); } protected void addRange(int paramInt1, int paramInt2) { throw new RuntimeException("Not supported."); } protected void sortRanges() { throw new RuntimeException("Not supported."); } protected void compactRanges() { throw new RuntimeException("Not supported."); } protected void mergeRanges(Token paramToken) { throw new RuntimeException("Not supported."); }
/*      */   protected void subtractRanges(Token paramToken) { throw new RuntimeException("Not supported."); }
/* 1070 */   static synchronized Token getCombiningCharacterSequence() { if (token_ccs != null) {
/* 1071 */       return token_ccs;
/*      */     }
/* 1073 */     ClosureToken closureToken = createClosure(getRange("M", true));
/* 1074 */     ConcatToken concatToken = createConcat(getRange("M", false), closureToken);
/* 1075 */     token_ccs = concatToken;
/* 1076 */     return token_ccs; }
/*      */   protected void intersectRanges(Token paramToken) { throw new RuntimeException("Not supported."); }
/*      */   static Token complementRanges(Token paramToken) { return RangeToken.complementRanges(paramToken); }
/*      */   void setMin(int paramInt) {}
/*      */   void setMax(int paramInt) {}
/*      */   int getMin() { return -1; }
/*      */   int getMax() { return -1; }
/*      */   int getReferenceNumber() { return 0; }
/*      */   String getString() { return null; }
/*      */   int getParenNumber() { return 0; }
/*      */   int getChar() { return -1; }
/*      */   public String toString() { return toString(0); } public String toString(int paramInt) { return (this.type == 11) ? "." : ""; } final int getMinLength() { int i; int j; byte b; switch (this.type) { case 1: i = 0; for (j = 0; j < size(); j++) i += getChild(j).getMinLength();  return i;case 2: case 26: if (size() == 0) return 0;  j = getChild(0).getMinLength(); for (b = 1; b < size(); b++) { int k = getChild(b).getMinLength(); if (k < j) j = k;  }  return j;case 3: case 9: if (getMin() >= 0) return getMin() * getChild(0).getMinLength();  return 0;case 7: case 8: return 0;case 0: case 4: case 5: case 11: return 1;case 6: case 24: case 25: return getChild(0).getMinLength();case 12: return 0;case 10: return getString().length();case 20: case 21: case 22: case 23: return 0; }  throw new RuntimeException("Token#getMinLength(): Invalid Type: " + this.type); } final int getMaxLength() { int i; int j; byte b; switch (this.type) { case 1: i = 0; for (j = 0; j < size(); j++) { int k = getChild(j).getMaxLength(); if (k < 0) return -1;  i += k; }  return i;case 2: case 26: if (size() == 0) return 0;  j = getChild(0).getMaxLength(); for (b = 1; j >= 0 && b < size(); b++) { int k = getChild(b).getMaxLength(); if (k < 0) { j = -1; break; }  if (k > j) j = k;  }  return j;case 3: case 9: if (getMax() >= 0) return getMax() * getChild(0).getMaxLength();  return -1;case 7: case 8: return 0;case 0: return 1;case 4: case 5: case 11: return 2;case 6: case 24: case 25: return getChild(0).getMaxLength();case 12: return -1;case 10: return getString().length();case 20: case 21: case 22: case 23: return 0; }  throw new RuntimeException("Token#getMaxLength(): Invalid Type: " + this.type); } private static final boolean isSet(int paramInt1, int paramInt2) { return ((paramInt1 & paramInt2) == paramInt2); } final int analyzeFirstCharacter(RangeToken paramRangeToken, int paramInt) { int i; int j; boolean bool; int k; int m; int n; int i1; char c; switch (this.type) { case 1: i = 0; for (j = 0; j < size() && (i = getChild(j).analyzeFirstCharacter(paramRangeToken, paramInt)) == 0; j++); return i;case 2: if (size() == 0) return 0;  j = 0; bool = false; for (k = 0; k < size(); k++) { j = getChild(k).analyzeFirstCharacter(paramRangeToken, paramInt); if (j == 2) break;  if (j == 0) bool = true;  }  return bool ? 0 : j;case 26: k = getChild(0).analyzeFirstCharacter(paramRangeToken, paramInt); if (size() == 1) return 0;  if (k == 2) return k;  m = getChild(1).analyzeFirstCharacter(paramRangeToken, paramInt); if (m == 2) return m;  return (k == 0 || m == 0) ? 0 : 1;case 3: case 9: getChild(0).analyzeFirstCharacter(paramRangeToken, paramInt); return 0;case 7: case 8: return 0;case 0: n = getChar(); paramRangeToken.addRange(n, n); if (n < 65536 && isSet(paramInt, 2)) { n = Character.toUpperCase((char)n); paramRangeToken.addRange(n, n); n = Character.toLowerCase((char)n); paramRangeToken.addRange(n, n); }  return 1;case 11: if (isSet(paramInt, 4)) return 0;  return 0;case 4: if (isSet(paramInt, 2)) { paramRangeToken.mergeRanges(((RangeToken)this).getCaseInsensitiveToken()); } else { paramRangeToken.mergeRanges(this); }  return 1;case 5: if (isSet(paramInt, 2)) { paramRangeToken.mergeRanges(complementRanges(((RangeToken)this).getCaseInsensitiveToken())); } else { paramRangeToken.mergeRanges(complementRanges(this)); }  return 1;case 6: case 24: return getChild(0).analyzeFirstCharacter(paramRangeToken, paramInt);case 25: paramInt |= ((ModifierToken)this).getOptions(); paramInt &= ((ModifierToken)this).getOptionsMask() ^ 0xFFFFFFFF; return getChild(0).analyzeFirstCharacter(paramRangeToken, paramInt);case 12: paramRangeToken.addRange(0, 1114111); return 2;case 10: i1 = getString().charAt(0); if (REUtil.isHighSurrogate(i1) && getString().length() >= 2 && REUtil.isLowSurrogate(c = getString().charAt(1))) i1 = REUtil.composeFromSurrogates(i1, c);  paramRangeToken.addRange(i1, i1); if (i1 < 65536 && isSet(paramInt, 2)) { i1 = Character.toUpperCase((char)i1); paramRangeToken.addRange(i1, i1); i1 = Character.toLowerCase((char)i1); paramRangeToken.addRange(i1, i1); }  return 1;case 20: case 21: case 22: case 23: return 0; }  throw new RuntimeException("Token#analyzeHeadCharacter(): Invalid Type: " + this.type); } private final boolean isShorterThan(Token paramToken) { int i; int j; if (paramToken == null) return false;  if (this.type == 10) { i = getString().length(); } else { throw new RuntimeException("Internal Error: Illegal type: " + this.type); }  if (paramToken.type == 10) { j = paramToken.getString().length(); } else { throw new RuntimeException("Internal Error: Illegal type: " + paramToken.type); }  return (i < j); } static class FixedStringContainer {
/*      */     Token token = null; int options = 0;
/*      */   } final void findFixedString(FixedStringContainer paramFixedStringContainer, int paramInt) { Token token; int i; byte b; switch (this.type) { case 1: token = null; i = 0; for (b = 0; b < size(); b++) { getChild(b).findFixedString(paramFixedStringContainer, paramInt); if (token == null || token.isShorterThan(paramFixedStringContainer.token)) { token = paramFixedStringContainer.token; i = paramFixedStringContainer.options; }  }  paramFixedStringContainer.token = token; paramFixedStringContainer.options = i; return;case 2: case 3: case 4: case 5: case 7: case 8: case 9: case 11: case 12: case 20: case 21: case 22: case 23: case 26: paramFixedStringContainer.token = null; return;case 0: paramFixedStringContainer.token = null; return;case 10: paramFixedStringContainer.token = this; paramFixedStringContainer.options = paramInt; return;case 6: case 24: getChild(0).findFixedString(paramFixedStringContainer, paramInt); return;case 25: paramInt |= ((ModifierToken)this).getOptions(); paramInt &= ((ModifierToken)this).getOptionsMask() ^ 0xFFFFFFFF; getChild(0).findFixedString(paramFixedStringContainer, paramInt); return; }  throw new RuntimeException("Token#findFixedString(): Invalid Type: " + this.type); } boolean match(int paramInt) { throw new RuntimeException("NFAArrow#match(): Internal error: " + this.type); } protected static RangeToken getRange(String paramString, boolean paramBoolean) { if (categories.size() == 0) synchronized (categories) { Token[] arrayOfToken = new Token[categoryNames.length]; int i; for (i = 0; i < arrayOfToken.length; i++) arrayOfToken[i] = createRange();  byte b1; for (b1 = 0; b1 < 65536; b1++) { i = Character.getType((char)b1); if (i == 21 || i == 22) { if (b1 == '«' || b1 == '‘' || b1 == '‛' || b1 == '“' || b1 == '‟' || b1 == '‹') i = 29;  if (b1 == '»' || b1 == '’' || b1 == '”' || b1 == '›') i = 30;  }  arrayOfToken[i].addRange(b1, b1); switch (i) { case 1: case 2: case 3: case 4: case 5: i = 31; break;case 6: case 7: case 8: i = 32; break;case 9: case 10: case 11: i = 33; break;case 12: case 13: case 14: i = 34; break;case 0: case 15: case 16: case 18: case 19: i = 35; break;case 20: case 21: case 22: case 23: case 24: case 29: case 30: i = 36; break;case 25: case 26: case 27: case 28: i = 37; break;default: throw new RuntimeException("org.apache.xerces.utils.regex.Token#getRange(): Unknown Unicode category: " + i); }  arrayOfToken[i].addRange(b1, b1); }  arrayOfToken[0].addRange(65536, 1114111); for (b1 = 0; b1 < arrayOfToken.length; b1++) { if (categoryNames[b1] != null) { if (b1 == 0) arrayOfToken[b1].addRange(65536, 1114111);  categories.put(categoryNames[b1], arrayOfToken[b1]); categories2.put(categoryNames[b1], complementRanges(arrayOfToken[b1])); }  }  StringBuffer stringBuffer = new StringBuffer(50); for (byte b2 = 0; b2 < blockNames.length; b2++) { RangeToken rangeToken = createRange(); if (b2 < 84) { int j = b2 * 2; char c1 = "\000ÿĀſƀɏɐʯʰ˿̀ͯͰϿЀӿ԰֏֐׿؀ۿ܀ݏހ޿ऀॿঀ৿਀੿઀૿଀୿஀௿ఀ౿ಀ೿ഀൿ඀෿฀๿຀໿ༀ࿿က႟Ⴀჿᄀᇿሀ፿Ꭰ᏿᐀ᙿ ᚟ᚠ᛿ក៿᠀᢯Ḁỿἀ῿ ⁯⁰₟₠⃏⃐⃿℀⅏⅐↏←⇿∀⋿⌀⏿␀␿⑀⑟①⓿─╿▀▟■◿☀⛿✀➿⠀⣿⺀⻿⼀⿟⿰⿿　〿぀ゟ゠ヿ㄀ㄯ㄰㆏㆐㆟ㆠㆿ㈀㋿㌀㏿㐀䶵一鿿ꀀ꒏꒐꓏가힣豈﫿ﬀﭏﭐ﷿︠︯︰﹏﹐﹯ﹰ﻾﻿﻿＀￯".charAt(j); char c2 = "\000ÿĀſƀɏɐʯʰ˿̀ͯͰϿЀӿ԰֏֐׿؀ۿ܀ݏހ޿ऀॿঀ৿਀੿઀૿଀୿஀௿ఀ౿ಀ೿ഀൿ඀෿฀๿຀໿ༀ࿿က႟Ⴀჿᄀᇿሀ፿Ꭰ᏿᐀ᙿ ᚟ᚠ᛿ក៿᠀᢯Ḁỿἀ῿ ⁯⁰₟₠⃏⃐⃿℀⅏⅐↏←⇿∀⋿⌀⏿␀␿⑀⑟①⓿─╿▀▟■◿☀⛿✀➿⠀⣿⺀⻿⼀⿟⿰⿿　〿぀ゟ゠ヿ㄀ㄯ㄰㆏㆐㆟ㆠㆿ㈀㋿㌀㏿㐀䶵一鿿ꀀ꒏꒐꓏가힣豈﫿ﬀﭏﭐ﷿︠︯︰﹏﹐﹯ﹰ﻾﻿﻿＀￯".charAt(j + 1); rangeToken.addRange(c1, c2); } else { int j = (b2 - 84) * 2; rangeToken.addRange(nonBMPBlockRanges[j], nonBMPBlockRanges[j + 1]); }  String str = blockNames[b2]; if (str.equals("Specials")) rangeToken.addRange(65520, 65533);  if (str.equals("Private Use")) { rangeToken.addRange(983040, 1048573); rangeToken.addRange(1048576, 1114109); }  categories.put(str, rangeToken); categories2.put(str, complementRanges(rangeToken)); stringBuffer.setLength(0); stringBuffer.append("Is"); if (str.indexOf(' ') >= 0) { for (byte b = 0; b < str.length(); b++) { if (str.charAt(b) != ' ') stringBuffer.append(str.charAt(b));  }  } else { stringBuffer.append(str); }  setAlias(stringBuffer.toString(), str, true); }  setAlias("ASSIGNED", "Cn", false); setAlias("UNASSIGNED", "Cn", true); RangeToken rangeToken1 = createRange(); rangeToken1.addRange(0, 1114111); categories.put("ALL", rangeToken1); categories2.put("ALL", complementRanges(rangeToken1)); registerNonXS("ASSIGNED"); registerNonXS("UNASSIGNED"); registerNonXS("ALL"); RangeToken rangeToken2 = createRange(); rangeToken2.mergeRanges(arrayOfToken[1]); rangeToken2.mergeRanges(arrayOfToken[2]); rangeToken2.mergeRanges(arrayOfToken[5]); categories.put("IsAlpha", rangeToken2); categories2.put("IsAlpha", complementRanges(rangeToken2)); registerNonXS("IsAlpha"); RangeToken rangeToken3 = createRange(); rangeToken3.mergeRanges(rangeToken2); rangeToken3.mergeRanges(arrayOfToken[9]); categories.put("IsAlnum", rangeToken3); categories2.put("IsAlnum", complementRanges(rangeToken3)); registerNonXS("IsAlnum"); RangeToken rangeToken4 = createRange(); rangeToken4.mergeRanges(token_spaces); rangeToken4.mergeRanges(arrayOfToken[34]); categories.put("IsSpace", rangeToken4); categories2.put("IsSpace", complementRanges(rangeToken4)); registerNonXS("IsSpace"); RangeToken rangeToken5 = createRange(); rangeToken5.mergeRanges(rangeToken3); rangeToken5.addRange(95, 95); categories.put("IsWord", rangeToken5); categories2.put("IsWord", complementRanges(rangeToken5)); registerNonXS("IsWord"); RangeToken rangeToken6 = createRange(); rangeToken6.addRange(0, 127); categories.put("IsASCII", rangeToken6); categories2.put("IsASCII", complementRanges(rangeToken6)); registerNonXS("IsASCII"); RangeToken rangeToken7 = createRange(); rangeToken7.mergeRanges(arrayOfToken[35]); rangeToken7.addRange(32, 32); categories.put("IsGraph", complementRanges(rangeToken7)); categories2.put("IsGraph", rangeToken7); registerNonXS("IsGraph"); RangeToken rangeToken8 = createRange(); rangeToken8.addRange(48, 57); rangeToken8.addRange(65, 70); rangeToken8.addRange(97, 102); categories.put("IsXDigit", complementRanges(rangeToken8)); categories2.put("IsXDigit", rangeToken8); registerNonXS("IsXDigit"); setAlias("IsDigit", "Nd", true); setAlias("IsUpper", "Lu", true); setAlias("IsLower", "Ll", true); setAlias("IsCntrl", "C", true); setAlias("IsPrint", "C", false); setAlias("IsPunct", "P", true); registerNonXS("IsDigit"); registerNonXS("IsUpper"); registerNonXS("IsLower"); registerNonXS("IsCntrl"); registerNonXS("IsPrint"); registerNonXS("IsPunct"); setAlias("alpha", "IsAlpha", true); setAlias("alnum", "IsAlnum", true); setAlias("ascii", "IsASCII", true); setAlias("cntrl", "IsCntrl", true); setAlias("digit", "IsDigit", true); setAlias("graph", "IsGraph", true); setAlias("lower", "IsLower", true); setAlias("print", "IsPrint", true); setAlias("punct", "IsPunct", true); setAlias("space", "IsSpace", true); setAlias("upper", "IsUpper", true); setAlias("word", "IsWord", true); setAlias("xdigit", "IsXDigit", true); registerNonXS("alpha"); registerNonXS("alnum"); registerNonXS("ascii"); registerNonXS("cntrl"); registerNonXS("digit"); registerNonXS("graph"); registerNonXS("lower"); registerNonXS("print"); registerNonXS("punct"); registerNonXS("space"); registerNonXS("upper"); registerNonXS("word"); registerNonXS("xdigit"); }   return paramBoolean ? (RangeToken)categories.get(paramString) : (RangeToken)categories2.get(paramString); } protected static RangeToken getRange(String paramString, boolean paramBoolean1, boolean paramBoolean2) { RangeToken rangeToken = getRange(paramString, paramBoolean1); if (paramBoolean2 && rangeToken != null && isRegisterNonXS(paramString)) rangeToken = null;  return rangeToken; } protected static void registerNonXS(String paramString) { if (nonxs == null) nonxs = new Hashtable();  nonxs.put(paramString, paramString); } protected static boolean isRegisterNonXS(String paramString) { if (nonxs == null) return false;  return nonxs.containsKey(paramString); } private static void setAlias(String paramString1, String paramString2, boolean paramBoolean) { Token token1 = (Token)categories.get(paramString2); Token token2 = (Token)categories2.get(paramString2); if (paramBoolean) { categories.put(paramString1, token1); categories2.put(paramString1, token2); } else { categories2.put(paramString1, token1); categories.put(paramString1, token2); }  } static synchronized Token getGraphemePattern() { if (token_grapheme != null) return token_grapheme;  RangeToken rangeToken1 = createRange(); rangeToken1.mergeRanges(getRange("ASSIGNED", true)); rangeToken1.subtractRanges(getRange("M", true)); rangeToken1.subtractRanges(getRange("C", true)); RangeToken rangeToken2 = createRange(); for (byte b = 0; b < "्্੍્୍்్್്ฺ྄".length(); b++) { char c = "्্੍્୍்్್്ฺ྄".charAt(b); rangeToken2.addRange(b, b); }  RangeToken rangeToken3 = createRange(); rangeToken3.mergeRanges(getRange("M", true)); rangeToken3.addRange(4448, 4607); rangeToken3.addRange(65438, 65439); UnionToken unionToken1 = createUnion(); unionToken1.addChild(rangeToken1); unionToken1.addChild(token_empty); UnionToken unionToken2 = createUnion(); unionToken2.addChild(createConcat(rangeToken2, getRange("L", true))); unionToken2.addChild(rangeToken3); ClosureToken closureToken = createClosure(unionToken2); ConcatToken concatToken = createConcat(unionToken1, closureToken); token_grapheme = concatToken; return token_grapheme; } static class StringToken extends Token implements Serializable {
/* 1090 */     String string; StringToken(int param1Int1, String param1String, int param1Int2) { super(param1Int1);
/* 1091 */       this.string = param1String;
/* 1092 */       this.refNumber = param1Int2; }
/*      */     
/*      */     int refNumber;
/*      */     int getReferenceNumber() {
/* 1096 */       return this.refNumber;
/*      */     }
/*      */     String getString() {
/* 1099 */       return this.string;
/*      */     }
/*      */     
/*      */     public String toString(int param1Int) {
/* 1103 */       if (this.type == 12) {
/* 1104 */         return "\\" + this.refNumber;
/*      */       }
/* 1106 */       return REUtil.quoteMeta(this.string);
/*      */     }
/*      */   }
/*      */   
/*      */   static class ConcatToken
/*      */     extends Token
/*      */     implements Serializable
/*      */   {
/*      */     Token child;
/*      */     Token child2;
/*      */     
/*      */     ConcatToken(Token param1Token1, Token param1Token2) {
/* 1118 */       super(1);
/* 1119 */       this.child = param1Token1;
/* 1120 */       this.child2 = param1Token2;
/*      */     }
/*      */     
/*      */     int size() {
/* 1124 */       return 2;
/*      */     }
/*      */     Token getChild(int param1Int) {
/* 1127 */       return (param1Int == 0) ? this.child : this.child2;
/*      */     }
/*      */     
/*      */     public String toString(int param1Int) {
/*      */       String str;
/* 1132 */       if (this.child2.type == 3 && this.child2.getChild(0) == this.child) {
/* 1133 */         str = this.child.toString(param1Int) + "+";
/* 1134 */       } else if (this.child2.type == 9 && this.child2.getChild(0) == this.child) {
/* 1135 */         str = this.child.toString(param1Int) + "+?";
/*      */       } else {
/* 1137 */         str = this.child.toString(param1Int) + this.child2.toString(param1Int);
/* 1138 */       }  return str;
/*      */     }
/*      */   }
/*      */   
/*      */   static class CharToken
/*      */     extends Token
/*      */     implements Serializable
/*      */   {
/*      */     int chardata;
/*      */     
/*      */     CharToken(int param1Int1, int param1Int2) {
/* 1149 */       super(param1Int1);
/* 1150 */       this.chardata = param1Int2;
/*      */     }
/*      */     
/*      */     int getChar() {
/* 1154 */       return this.chardata;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString(int param1Int) {
/* 1159 */       switch (this.type)
/*      */       { case 0:
/* 1161 */           switch (this.chardata) { case 40: case 41: case 42: case 43: case 46: case 63: case 91:
/*      */             case 92:
/*      */             case 123:
/*      */             case 124:
/* 1165 */               str = "\\" + (char)this.chardata;
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
/* 1192 */               return str;case 12: str = "\\f"; return str;case 10: str = "\\n"; return str;case 13: str = "\\r"; return str;case 9: str = "\\t"; return str;case 27: str = "\\e"; return str; }  if (this.chardata >= 65536) { String str1 = "0" + Integer.toHexString(this.chardata); str = "\\v" + str1.substring(str1.length() - 6, str1.length()); } else { str = "" + (char)this.chardata; }  return str;case 8: if (this == Token.token_linebeginning || this == Token.token_lineend) { str = "" + (char)this.chardata; } else { str = "\\" + (char)this.chardata; }  return str; }  String str = null; return str;
/*      */     }
/*      */     
/*      */     boolean match(int param1Int) {
/* 1196 */       if (this.type == 0) {
/* 1197 */         return (param1Int == this.chardata);
/*      */       }
/* 1199 */       throw new RuntimeException("NFAArrow#match(): Internal error: " + this.type);
/*      */     }
/*      */   }
/*      */   
/*      */   static class ClosureToken
/*      */     extends Token
/*      */     implements Serializable
/*      */   {
/*      */     int min;
/*      */     int max;
/*      */     Token child;
/*      */     
/*      */     ClosureToken(int param1Int, Token param1Token) {
/* 1212 */       super(param1Int);
/* 1213 */       this.child = param1Token;
/* 1214 */       setMin(-1);
/* 1215 */       setMax(-1);
/*      */     }
/*      */     
/*      */     int size() {
/* 1219 */       return 1;
/*      */     }
/*      */     Token getChild(int param1Int) {
/* 1222 */       return this.child;
/*      */     }
/*      */     
/*      */     final void setMin(int param1Int) {
/* 1226 */       this.min = param1Int;
/*      */     }
/*      */     final void setMax(int param1Int) {
/* 1229 */       this.max = param1Int;
/*      */     }
/*      */     final int getMin() {
/* 1232 */       return this.min;
/*      */     }
/*      */     final int getMax() {
/* 1235 */       return this.max;
/*      */     }
/*      */     
/*      */     public String toString(int param1Int) {
/*      */       String str;
/* 1240 */       if (this.type == 3) {
/* 1241 */         if (getMin() < 0 && getMax() < 0) {
/* 1242 */           str = this.child.toString(param1Int) + "*";
/* 1243 */         } else if (getMin() == getMax()) {
/* 1244 */           str = this.child.toString(param1Int) + "{" + getMin() + "}";
/* 1245 */         } else if (getMin() >= 0 && getMax() >= 0) {
/* 1246 */           str = this.child.toString(param1Int) + "{" + getMin() + "," + getMax() + "}";
/* 1247 */         } else if (getMin() >= 0 && getMax() < 0) {
/* 1248 */           str = this.child.toString(param1Int) + "{" + getMin() + ",}";
/*      */         } else {
/* 1250 */           throw new RuntimeException("Token#toString(): CLOSURE " + getMin() + ", " + getMax());
/*      */         }
/*      */       
/* 1253 */       } else if (getMin() < 0 && getMax() < 0) {
/* 1254 */         str = this.child.toString(param1Int) + "*?";
/* 1255 */       } else if (getMin() == getMax()) {
/* 1256 */         str = this.child.toString(param1Int) + "{" + getMin() + "}?";
/* 1257 */       } else if (getMin() >= 0 && getMax() >= 0) {
/* 1258 */         str = this.child.toString(param1Int) + "{" + getMin() + "," + getMax() + "}?";
/* 1259 */       } else if (getMin() >= 0 && getMax() < 0) {
/* 1260 */         str = this.child.toString(param1Int) + "{" + getMin() + ",}?";
/*      */       } else {
/* 1262 */         throw new RuntimeException("Token#toString(): NONGREEDYCLOSURE " + getMin() + ", " + getMax());
/*      */       } 
/*      */       
/* 1265 */       return str;
/*      */     }
/*      */   }
/*      */   
/*      */   static class ParenToken
/*      */     extends Token
/*      */     implements Serializable
/*      */   {
/*      */     Token child;
/*      */     int parennumber;
/*      */     
/*      */     ParenToken(int param1Int1, Token param1Token, int param1Int2) {
/* 1277 */       super(param1Int1);
/* 1278 */       this.child = param1Token;
/* 1279 */       this.parennumber = param1Int2;
/*      */     }
/*      */     
/*      */     int size() {
/* 1283 */       return 1;
/*      */     }
/*      */     Token getChild(int param1Int) {
/* 1286 */       return this.child;
/*      */     }
/*      */     
/*      */     int getParenNumber() {
/* 1290 */       return this.parennumber;
/*      */     }
/*      */     
/*      */     public String toString(int param1Int) {
/* 1294 */       String str = null;
/* 1295 */       switch (this.type) {
/*      */         case 6:
/* 1297 */           if (this.parennumber == 0) {
/* 1298 */             str = "(?:" + this.child.toString(param1Int) + ")"; break;
/*      */           } 
/* 1300 */           str = "(" + this.child.toString(param1Int) + ")";
/*      */           break;
/*      */ 
/*      */         
/*      */         case 20:
/* 1305 */           str = "(?=" + this.child.toString(param1Int) + ")";
/*      */           break;
/*      */         case 21:
/* 1308 */           str = "(?!" + this.child.toString(param1Int) + ")";
/*      */           break;
/*      */         case 22:
/* 1311 */           str = "(?<=" + this.child.toString(param1Int) + ")";
/*      */           break;
/*      */         case 23:
/* 1314 */           str = "(?<!" + this.child.toString(param1Int) + ")";
/*      */           break;
/*      */         case 24:
/* 1317 */           str = "(?>" + this.child.toString(param1Int) + ")";
/*      */           break;
/*      */       } 
/* 1320 */       return str;
/*      */     }
/*      */   }
/*      */   
/*      */   static class ConditionToken
/*      */     extends Token
/*      */     implements Serializable {
/*      */     int refNumber;
/*      */     Token condition;
/*      */     Token yes;
/*      */     Token no;
/*      */     
/*      */     ConditionToken(int param1Int, Token param1Token1, Token param1Token2, Token param1Token3) {
/* 1333 */       super(26);
/* 1334 */       this.refNumber = param1Int;
/* 1335 */       this.condition = param1Token1;
/* 1336 */       this.yes = param1Token2;
/* 1337 */       this.no = param1Token3;
/*      */     }
/*      */     int size() {
/* 1340 */       return (this.no == null) ? 1 : 2;
/*      */     }
/*      */     Token getChild(int param1Int) {
/* 1343 */       if (param1Int == 0) return this.yes; 
/* 1344 */       if (param1Int == 1) return this.no; 
/* 1345 */       throw new RuntimeException("Internal Error: " + param1Int);
/*      */     }
/*      */     
/*      */     public String toString(int param1Int) {
/*      */       String str;
/* 1350 */       if (this.refNumber > 0) {
/* 1351 */         str = "(?(" + this.refNumber + ")";
/* 1352 */       } else if (this.condition.type == 8) {
/* 1353 */         str = "(?(" + this.condition + ")";
/*      */       } else {
/* 1355 */         str = "(?" + this.condition;
/*      */       } 
/*      */       
/* 1358 */       if (this.no == null) {
/* 1359 */         str = str + this.yes + ")";
/*      */       } else {
/* 1361 */         str = str + this.yes + "|" + this.no + ")";
/*      */       } 
/* 1363 */       return str;
/*      */     }
/*      */   }
/*      */   
/*      */   static class ModifierToken
/*      */     extends Token
/*      */     implements Serializable
/*      */   {
/*      */     Token child;
/*      */     int add;
/*      */     int mask;
/*      */     
/*      */     ModifierToken(Token param1Token, int param1Int1, int param1Int2) {
/* 1376 */       super(25);
/* 1377 */       this.child = param1Token;
/* 1378 */       this.add = param1Int1;
/* 1379 */       this.mask = param1Int2;
/*      */     }
/*      */     
/*      */     int size() {
/* 1383 */       return 1;
/*      */     }
/*      */     Token getChild(int param1Int) {
/* 1386 */       return this.child;
/*      */     }
/*      */     
/*      */     int getOptions() {
/* 1390 */       return this.add;
/*      */     }
/*      */     int getOptionsMask() {
/* 1393 */       return this.mask;
/*      */     }
/*      */     
/*      */     public String toString(int param1Int) {
/* 1397 */       return "(?" + ((this.add == 0) ? "" : REUtil.createOptionString(this.add)) + ((this.mask == 0) ? "" : REUtil.createOptionString(this.mask)) + ":" + this.child.toString(param1Int) + ")";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class UnionToken
/*      */     extends Token
/*      */     implements Serializable
/*      */   {
/*      */     Vector children;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     UnionToken(int param1Int) {
/* 1414 */       super(param1Int);
/*      */     }
/*      */     void addChild(Token param1Token) {
/*      */       StringBuffer stringBuffer;
/* 1418 */       if (param1Token == null)
/* 1419 */         return;  if (this.children == null) this.children = new Vector(); 
/* 1420 */       if (this.type == 2) {
/* 1421 */         this.children.addElement(param1Token);
/*      */         
/*      */         return;
/*      */       } 
/* 1425 */       if (param1Token.type == 1) {
/* 1426 */         for (byte b1 = 0; b1 < param1Token.size(); b1++)
/* 1427 */           addChild(param1Token.getChild(b1)); 
/*      */         return;
/*      */       } 
/* 1430 */       int i = this.children.size();
/* 1431 */       if (i == 0) {
/* 1432 */         this.children.addElement(param1Token);
/*      */         return;
/*      */       } 
/* 1435 */       Token token = this.children.elementAt(i - 1);
/* 1436 */       if ((token.type != 0 && token.type != 10) || (param1Token.type != 0 && param1Token.type != 10)) {
/*      */         
/* 1438 */         this.children.addElement(param1Token);
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */ 
/*      */       
/* 1445 */       byte b = (param1Token.type == 0) ? 2 : param1Token.getString().length();
/* 1446 */       if (token.type == 0) {
/* 1447 */         stringBuffer = new StringBuffer(2 + b);
/* 1448 */         int j = token.getChar();
/* 1449 */         if (j >= 65536) {
/* 1450 */           stringBuffer.append(REUtil.decomposeToSurrogates(j));
/*      */         } else {
/* 1452 */           stringBuffer.append((char)j);
/* 1453 */         }  token = Token.createString(null);
/* 1454 */         this.children.setElementAt(token, i - 1);
/*      */       } else {
/* 1456 */         stringBuffer = new StringBuffer(token.getString().length() + b);
/* 1457 */         stringBuffer.append(token.getString());
/*      */       } 
/*      */       
/* 1460 */       if (param1Token.type == 0)
/* 1461 */       { int j = param1Token.getChar();
/* 1462 */         if (j >= 65536) {
/* 1463 */           stringBuffer.append(REUtil.decomposeToSurrogates(j));
/*      */         } else {
/* 1465 */           stringBuffer.append((char)j);
/*      */         }  }
/* 1467 */       else { stringBuffer.append(param1Token.getString()); }
/*      */ 
/*      */       
/* 1470 */       ((Token.StringToken)token).string = new String(stringBuffer);
/*      */     }
/*      */     
/*      */     int size() {
/* 1474 */       return (this.children == null) ? 0 : this.children.size();
/*      */     }
/*      */     Token getChild(int param1Int) {
/* 1477 */       return this.children.elementAt(param1Int);
/*      */     }
/*      */     
/*      */     public String toString(int param1Int) {
/*      */       String str;
/* 1482 */       if (this.type == 1) {
/* 1483 */         if (this.children.size() == 2)
/* 1484 */         { Token token1 = getChild(0);
/* 1485 */           Token token2 = getChild(1);
/* 1486 */           if (token2.type == 3 && token2.getChild(0) == token1) {
/* 1487 */             str = token1.toString(param1Int) + "+";
/* 1488 */           } else if (token2.type == 9 && token2.getChild(0) == token1) {
/* 1489 */             str = token1.toString(param1Int) + "+?";
/*      */           } else {
/* 1491 */             str = token1.toString(param1Int) + token2.toString(param1Int);
/*      */           }  }
/* 1493 */         else { StringBuffer stringBuffer = new StringBuffer();
/* 1494 */           for (byte b = 0; b < this.children.size(); b++) {
/* 1495 */             stringBuffer.append(((Token)this.children.elementAt(b)).toString(param1Int));
/*      */           }
/* 1497 */           str = new String(stringBuffer); }
/*      */         
/* 1499 */         return str;
/*      */       } 
/* 1501 */       if (this.children.size() == 2 && (getChild(1)).type == 7) {
/* 1502 */         str = getChild(0).toString(param1Int) + "?";
/* 1503 */       } else if (this.children.size() == 2 && (getChild(0)).type == 7) {
/*      */         
/* 1505 */         str = getChild(1).toString(param1Int) + "??";
/*      */       } else {
/* 1507 */         StringBuffer stringBuffer = new StringBuffer();
/* 1508 */         stringBuffer.append(((Token)this.children.elementAt(0)).toString(param1Int));
/* 1509 */         for (byte b = 1; b < this.children.size(); b++) {
/* 1510 */           stringBuffer.append('|');
/* 1511 */           stringBuffer.append(((Token)this.children.elementAt(b)).toString(param1Int));
/*      */         } 
/* 1513 */         str = new String(stringBuffer);
/*      */       } 
/* 1515 */       return str;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\Token.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */