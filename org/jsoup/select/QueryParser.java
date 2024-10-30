/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.jsoup.helper.StringUtil;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.parser.TokenQueue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class QueryParser
/*     */ {
/*  16 */   private static final String[] combinators = new String[] { ",", ">", "+", "~", " " };
/*  17 */   private static final String[] AttributeEvals = new String[] { "=", "!=", "^=", "$=", "*=", "~=" };
/*     */   
/*     */   private TokenQueue tq;
/*     */   private String query;
/*  21 */   private List<Evaluator> evals = new ArrayList<Evaluator>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private QueryParser(String paramString) {
/*  28 */     this.query = paramString;
/*  29 */     this.tq = new TokenQueue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Evaluator parse(String paramString) {
/*  38 */     QueryParser queryParser = new QueryParser(paramString);
/*  39 */     return queryParser.parse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Evaluator parse() {
/*  47 */     this.tq.consumeWhitespace();
/*     */     
/*  49 */     if (this.tq.matchesAny(combinators)) {
/*  50 */       this.evals.add(new StructuralEvaluator.Root());
/*  51 */       combinator(this.tq.consume());
/*     */     } else {
/*  53 */       findElements();
/*     */     } 
/*     */     
/*  56 */     while (!this.tq.isEmpty()) {
/*     */       
/*  58 */       boolean bool = this.tq.consumeWhitespace();
/*     */       
/*  60 */       if (this.tq.matchesAny(combinators)) {
/*  61 */         combinator(this.tq.consume()); continue;
/*  62 */       }  if (bool) {
/*  63 */         combinator(' '); continue;
/*     */       } 
/*  65 */       findElements();
/*     */     } 
/*     */ 
/*     */     
/*  69 */     if (this.evals.size() == 1) {
/*  70 */       return this.evals.get(0);
/*     */     }
/*  72 */     return new CombiningEvaluator.And(this.evals);
/*     */   }
/*     */   private void combinator(char paramChar) {
/*     */     Evaluator evaluator1, evaluator2;
/*  76 */     this.tq.consumeWhitespace();
/*  77 */     String str = consumeSubQuery();
/*     */ 
/*     */ 
/*     */     
/*  81 */     Evaluator evaluator3 = parse(str);
/*  82 */     boolean bool = false;
/*     */     
/*  84 */     if (this.evals.size() == 1) {
/*  85 */       evaluator1 = evaluator2 = this.evals.get(0);
/*     */       
/*  87 */       if (evaluator1 instanceof CombiningEvaluator.Or && paramChar != ',') {
/*  88 */         evaluator2 = ((CombiningEvaluator.Or)evaluator2).rightMostEvaluator();
/*  89 */         bool = true;
/*     */       } 
/*     */     } else {
/*     */       
/*  93 */       evaluator1 = evaluator2 = new CombiningEvaluator.And(this.evals);
/*     */     } 
/*  95 */     this.evals.clear();
/*     */ 
/*     */     
/*  98 */     if (paramChar == '>') {
/*  99 */       evaluator2 = new CombiningEvaluator.And(new Evaluator[] { evaluator3, new StructuralEvaluator.ImmediateParent(evaluator2) });
/* 100 */     } else if (paramChar == ' ') {
/* 101 */       evaluator2 = new CombiningEvaluator.And(new Evaluator[] { evaluator3, new StructuralEvaluator.Parent(evaluator2) });
/* 102 */     } else if (paramChar == '+') {
/* 103 */       evaluator2 = new CombiningEvaluator.And(new Evaluator[] { evaluator3, new StructuralEvaluator.ImmediatePreviousSibling(evaluator2) });
/* 104 */     } else if (paramChar == '~') {
/* 105 */       evaluator2 = new CombiningEvaluator.And(new Evaluator[] { evaluator3, new StructuralEvaluator.PreviousSibling(evaluator2) });
/* 106 */     } else if (paramChar == ',') {
/*     */       CombiningEvaluator.Or or;
/* 108 */       if (evaluator2 instanceof CombiningEvaluator.Or) {
/* 109 */         or = (CombiningEvaluator.Or)evaluator2;
/* 110 */         or.add(evaluator3);
/*     */       } else {
/* 112 */         or = new CombiningEvaluator.Or();
/* 113 */         or.add(evaluator2);
/* 114 */         or.add(evaluator3);
/*     */       } 
/* 116 */       evaluator2 = or;
/*     */     } else {
/*     */       
/* 119 */       throw new Selector.SelectorParseException("Unknown combinator: " + paramChar, new Object[0]);
/*     */     } 
/* 121 */     if (bool)
/* 122 */     { ((CombiningEvaluator.Or)evaluator1).replaceRightMostEvaluator(evaluator2); }
/* 123 */     else { evaluator1 = evaluator2; }
/* 124 */      this.evals.add(evaluator1);
/*     */   }
/*     */   
/*     */   private String consumeSubQuery() {
/* 128 */     StringBuilder stringBuilder = new StringBuilder();
/* 129 */     while (!this.tq.isEmpty()) {
/* 130 */       if (this.tq.matches("(")) {
/* 131 */         stringBuilder.append("(").append(this.tq.chompBalanced('(', ')')).append(")"); continue;
/* 132 */       }  if (this.tq.matches("[")) {
/* 133 */         stringBuilder.append("[").append(this.tq.chompBalanced('[', ']')).append("]"); continue;
/* 134 */       }  if (this.tq.matchesAny(combinators)) {
/*     */         break;
/*     */       }
/* 137 */       stringBuilder.append(this.tq.consume());
/*     */     } 
/* 139 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private void findElements() {
/* 143 */     if (this.tq.matchChomp("#")) {
/* 144 */       byId();
/* 145 */     } else if (this.tq.matchChomp(".")) {
/* 146 */       byClass();
/* 147 */     } else if (this.tq.matchesWord()) {
/* 148 */       byTag();
/* 149 */     } else if (this.tq.matches("[")) {
/* 150 */       byAttribute();
/* 151 */     } else if (this.tq.matchChomp("*")) {
/* 152 */       allElements();
/* 153 */     } else if (this.tq.matchChomp(":lt(")) {
/* 154 */       indexLessThan();
/* 155 */     } else if (this.tq.matchChomp(":gt(")) {
/* 156 */       indexGreaterThan();
/* 157 */     } else if (this.tq.matchChomp(":eq(")) {
/* 158 */       indexEquals();
/* 159 */     } else if (this.tq.matches(":has(")) {
/* 160 */       has();
/* 161 */     } else if (this.tq.matches(":contains(")) {
/* 162 */       contains(false);
/* 163 */     } else if (this.tq.matches(":containsOwn(")) {
/* 164 */       contains(true);
/* 165 */     } else if (this.tq.matches(":matches(")) {
/* 166 */       matches(false);
/* 167 */     } else if (this.tq.matches(":matchesOwn(")) {
/* 168 */       matches(true);
/* 169 */     } else if (this.tq.matches(":not(")) {
/* 170 */       not();
/* 171 */     } else if (this.tq.matchChomp(":nth-child(")) {
/* 172 */       cssNthChild(false, false);
/* 173 */     } else if (this.tq.matchChomp(":nth-last-child(")) {
/* 174 */       cssNthChild(true, false);
/* 175 */     } else if (this.tq.matchChomp(":nth-of-type(")) {
/* 176 */       cssNthChild(false, true);
/* 177 */     } else if (this.tq.matchChomp(":nth-last-of-type(")) {
/* 178 */       cssNthChild(true, true);
/* 179 */     } else if (this.tq.matchChomp(":first-child")) {
/* 180 */       this.evals.add(new Evaluator.IsFirstChild());
/* 181 */     } else if (this.tq.matchChomp(":last-child")) {
/* 182 */       this.evals.add(new Evaluator.IsLastChild());
/* 183 */     } else if (this.tq.matchChomp(":first-of-type")) {
/* 184 */       this.evals.add(new Evaluator.IsFirstOfType());
/* 185 */     } else if (this.tq.matchChomp(":last-of-type")) {
/* 186 */       this.evals.add(new Evaluator.IsLastOfType());
/* 187 */     } else if (this.tq.matchChomp(":only-child")) {
/* 188 */       this.evals.add(new Evaluator.IsOnlyChild());
/* 189 */     } else if (this.tq.matchChomp(":only-of-type")) {
/* 190 */       this.evals.add(new Evaluator.IsOnlyOfType());
/* 191 */     } else if (this.tq.matchChomp(":empty")) {
/* 192 */       this.evals.add(new Evaluator.IsEmpty());
/* 193 */     } else if (this.tq.matchChomp(":root")) {
/* 194 */       this.evals.add(new Evaluator.IsRoot());
/*     */     } else {
/* 196 */       throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", new Object[] { this.query, this.tq.remainder() });
/*     */     } 
/*     */   }
/*     */   
/*     */   private void byId() {
/* 201 */     String str = this.tq.consumeCssIdentifier();
/* 202 */     Validate.notEmpty(str);
/* 203 */     this.evals.add(new Evaluator.Id(str));
/*     */   }
/*     */   
/*     */   private void byClass() {
/* 207 */     String str = this.tq.consumeCssIdentifier();
/* 208 */     Validate.notEmpty(str);
/* 209 */     this.evals.add(new Evaluator.Class(str.trim().toLowerCase()));
/*     */   }
/*     */   
/*     */   private void byTag() {
/* 213 */     String str = this.tq.consumeElementSelector();
/* 214 */     Validate.notEmpty(str);
/*     */ 
/*     */     
/* 217 */     if (str.contains("|")) {
/* 218 */       str = str.replace("|", ":");
/*     */     }
/* 220 */     this.evals.add(new Evaluator.Tag(str.trim().toLowerCase()));
/*     */   }
/*     */   
/*     */   private void byAttribute() {
/* 224 */     TokenQueue tokenQueue = new TokenQueue(this.tq.chompBalanced('[', ']'));
/* 225 */     String str = tokenQueue.consumeToAny(AttributeEvals);
/* 226 */     Validate.notEmpty(str);
/* 227 */     tokenQueue.consumeWhitespace();
/*     */     
/* 229 */     if (tokenQueue.isEmpty()) {
/* 230 */       if (str.startsWith("^")) {
/* 231 */         this.evals.add(new Evaluator.AttributeStarting(str.substring(1)));
/*     */       } else {
/* 233 */         this.evals.add(new Evaluator.Attribute(str));
/*     */       } 
/* 235 */     } else if (tokenQueue.matchChomp("=")) {
/* 236 */       this.evals.add(new Evaluator.AttributeWithValue(str, tokenQueue.remainder()));
/*     */     }
/* 238 */     else if (tokenQueue.matchChomp("!=")) {
/* 239 */       this.evals.add(new Evaluator.AttributeWithValueNot(str, tokenQueue.remainder()));
/*     */     }
/* 241 */     else if (tokenQueue.matchChomp("^=")) {
/* 242 */       this.evals.add(new Evaluator.AttributeWithValueStarting(str, tokenQueue.remainder()));
/*     */     }
/* 244 */     else if (tokenQueue.matchChomp("$=")) {
/* 245 */       this.evals.add(new Evaluator.AttributeWithValueEnding(str, tokenQueue.remainder()));
/*     */     }
/* 247 */     else if (tokenQueue.matchChomp("*=")) {
/* 248 */       this.evals.add(new Evaluator.AttributeWithValueContaining(str, tokenQueue.remainder()));
/*     */     }
/* 250 */     else if (tokenQueue.matchChomp("~=")) {
/* 251 */       this.evals.add(new Evaluator.AttributeWithValueMatching(str, Pattern.compile(tokenQueue.remainder())));
/*     */     } else {
/* 253 */       throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", new Object[] { this.query, tokenQueue.remainder() });
/*     */     } 
/*     */   }
/*     */   
/*     */   private void allElements() {
/* 258 */     this.evals.add(new Evaluator.AllElements());
/*     */   }
/*     */ 
/*     */   
/*     */   private void indexLessThan() {
/* 263 */     this.evals.add(new Evaluator.IndexLessThan(consumeIndex()));
/*     */   }
/*     */   
/*     */   private void indexGreaterThan() {
/* 267 */     this.evals.add(new Evaluator.IndexGreaterThan(consumeIndex()));
/*     */   }
/*     */   
/*     */   private void indexEquals() {
/* 271 */     this.evals.add(new Evaluator.IndexEquals(consumeIndex()));
/*     */   }
/*     */ 
/*     */   
/* 275 */   private static final Pattern NTH_AB = Pattern.compile("((\\+|-)?(\\d+)?)n(\\s*(\\+|-)?\\s*\\d+)?", 2);
/* 276 */   private static final Pattern NTH_B = Pattern.compile("(\\+|-)?(\\d+)"); private void cssNthChild(boolean paramBoolean1, boolean paramBoolean2) {
/*     */     boolean bool;
/*     */     int i;
/* 279 */     String str = this.tq.chompTo(")").trim().toLowerCase();
/* 280 */     Matcher matcher1 = NTH_AB.matcher(str);
/* 281 */     Matcher matcher2 = NTH_B.matcher(str);
/*     */     
/* 283 */     if ("odd".equals(str)) {
/* 284 */       bool = true;
/* 285 */       i = 1;
/* 286 */     } else if ("even".equals(str)) {
/* 287 */       bool = true;
/* 288 */       i = 0;
/* 289 */     } else if (matcher1.matches()) {
/* 290 */       bool = (matcher1.group(3) != null) ? Integer.parseInt(matcher1.group(1).replaceFirst("^\\+", "")) : true;
/* 291 */       i = (matcher1.group(4) != null) ? Integer.parseInt(matcher1.group(4).replaceFirst("^\\+", "")) : 0;
/* 292 */     } else if (matcher2.matches()) {
/* 293 */       bool = false;
/* 294 */       i = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
/*     */     } else {
/* 296 */       throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", new Object[] { str });
/*     */     } 
/* 298 */     if (paramBoolean2) {
/* 299 */       if (paramBoolean1) {
/* 300 */         this.evals.add(new Evaluator.IsNthLastOfType(bool, i));
/*     */       } else {
/* 302 */         this.evals.add(new Evaluator.IsNthOfType(bool, i));
/*     */       } 
/* 304 */     } else if (paramBoolean1) {
/* 305 */       this.evals.add(new Evaluator.IsNthLastChild(bool, i));
/*     */     } else {
/* 307 */       this.evals.add(new Evaluator.IsNthChild(bool, i));
/*     */     } 
/*     */   }
/*     */   
/*     */   private int consumeIndex() {
/* 312 */     String str = this.tq.chompTo(")").trim();
/* 313 */     Validate.isTrue(StringUtil.isNumeric(str), "Index must be numeric");
/* 314 */     return Integer.parseInt(str);
/*     */   }
/*     */ 
/*     */   
/*     */   private void has() {
/* 319 */     this.tq.consume(":has");
/* 320 */     String str = this.tq.chompBalanced('(', ')');
/* 321 */     Validate.notEmpty(str, ":has(el) subselect must not be empty");
/* 322 */     this.evals.add(new StructuralEvaluator.Has(parse(str)));
/*     */   }
/*     */ 
/*     */   
/*     */   private void contains(boolean paramBoolean) {
/* 327 */     this.tq.consume(paramBoolean ? ":containsOwn" : ":contains");
/* 328 */     String str = TokenQueue.unescape(this.tq.chompBalanced('(', ')'));
/* 329 */     Validate.notEmpty(str, ":contains(text) query must not be empty");
/* 330 */     if (paramBoolean) {
/* 331 */       this.evals.add(new Evaluator.ContainsOwnText(str));
/*     */     } else {
/* 333 */       this.evals.add(new Evaluator.ContainsText(str));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void matches(boolean paramBoolean) {
/* 338 */     this.tq.consume(paramBoolean ? ":matchesOwn" : ":matches");
/* 339 */     String str = this.tq.chompBalanced('(', ')');
/* 340 */     Validate.notEmpty(str, ":matches(regex) query must not be empty");
/*     */     
/* 342 */     if (paramBoolean) {
/* 343 */       this.evals.add(new Evaluator.MatchesOwn(Pattern.compile(str)));
/*     */     } else {
/* 345 */       this.evals.add(new Evaluator.Matches(Pattern.compile(str)));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void not() {
/* 350 */     this.tq.consume(":not");
/* 351 */     String str = this.tq.chompBalanced('(', ')');
/* 352 */     Validate.notEmpty(str, ":not(selector) subselect must not be empty");
/*     */     
/* 354 */     this.evals.add(new StructuralEvaluator.Not(parse(str)));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\select\QueryParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */