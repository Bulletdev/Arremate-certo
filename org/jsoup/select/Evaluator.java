/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
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
/*     */ public abstract class Evaluator
/*     */ {
/*     */   public abstract boolean matches(Element paramElement1, Element paramElement2);
/*     */   
/*     */   public static final class Tag
/*     */     extends Evaluator
/*     */   {
/*     */     private String tagName;
/*     */     
/*     */     public Tag(String param1String) {
/*  38 */       this.tagName = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  43 */       return param1Element2.tagName().equals(this.tagName);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  48 */       return String.format("%s", new Object[] { this.tagName });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Id
/*     */     extends Evaluator
/*     */   {
/*     */     private String id;
/*     */     
/*     */     public Id(String param1String) {
/*  59 */       this.id = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  64 */       return this.id.equals(param1Element2.id());
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  69 */       return String.format("#%s", new Object[] { this.id });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Class
/*     */     extends Evaluator
/*     */   {
/*     */     private String className;
/*     */ 
/*     */     
/*     */     public Class(String param1String) {
/*  81 */       this.className = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  86 */       return param1Element2.hasClass(this.className);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  91 */       return String.format(".%s", new Object[] { this.className });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Attribute
/*     */     extends Evaluator
/*     */   {
/*     */     private String key;
/*     */ 
/*     */     
/*     */     public Attribute(String param1String) {
/* 103 */       this.key = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 108 */       return param1Element2.hasAttr(this.key);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 113 */       return String.format("[%s]", new Object[] { this.key });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class AttributeStarting
/*     */     extends Evaluator
/*     */   {
/*     */     private String keyPrefix;
/*     */ 
/*     */     
/*     */     public AttributeStarting(String param1String) {
/* 125 */       this.keyPrefix = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 130 */       List list = param1Element2.attributes().asList();
/* 131 */       for (org.jsoup.nodes.Attribute attribute : list) {
/* 132 */         if (attribute.getKey().startsWith(this.keyPrefix))
/* 133 */           return true; 
/*     */       } 
/* 135 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 140 */       return String.format("[^%s]", new Object[] { this.keyPrefix });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValue
/*     */     extends AttributeKeyPair
/*     */   {
/*     */     public AttributeWithValue(String param1String1, String param1String2) {
/* 150 */       super(param1String1, param1String2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 155 */       return (param1Element2.hasAttr(this.key) && this.value.equalsIgnoreCase(param1Element2.attr(this.key)));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 160 */       return String.format("[%s=%s]", new Object[] { this.key, this.value });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValueNot
/*     */     extends AttributeKeyPair
/*     */   {
/*     */     public AttributeWithValueNot(String param1String1, String param1String2) {
/* 170 */       super(param1String1, param1String2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 175 */       return !this.value.equalsIgnoreCase(param1Element2.attr(this.key));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 180 */       return String.format("[%s!=%s]", new Object[] { this.key, this.value });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValueStarting
/*     */     extends AttributeKeyPair
/*     */   {
/*     */     public AttributeWithValueStarting(String param1String1, String param1String2) {
/* 190 */       super(param1String1, param1String2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 195 */       return (param1Element2.hasAttr(this.key) && param1Element2.attr(this.key).toLowerCase().startsWith(this.value));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 200 */       return String.format("[%s^=%s]", new Object[] { this.key, this.value });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValueEnding
/*     */     extends AttributeKeyPair
/*     */   {
/*     */     public AttributeWithValueEnding(String param1String1, String param1String2) {
/* 210 */       super(param1String1, param1String2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 215 */       return (param1Element2.hasAttr(this.key) && param1Element2.attr(this.key).toLowerCase().endsWith(this.value));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 220 */       return String.format("[%s$=%s]", new Object[] { this.key, this.value });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValueContaining
/*     */     extends AttributeKeyPair
/*     */   {
/*     */     public AttributeWithValueContaining(String param1String1, String param1String2) {
/* 230 */       super(param1String1, param1String2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 235 */       return (param1Element2.hasAttr(this.key) && param1Element2.attr(this.key).toLowerCase().contains(this.value));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 240 */       return String.format("[%s*=%s]", new Object[] { this.key, this.value });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValueMatching
/*     */     extends Evaluator
/*     */   {
/*     */     String key;
/*     */     
/*     */     Pattern pattern;
/*     */     
/*     */     public AttributeWithValueMatching(String param1String, Pattern param1Pattern) {
/* 253 */       this.key = param1String.trim().toLowerCase();
/* 254 */       this.pattern = param1Pattern;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 259 */       return (param1Element2.hasAttr(this.key) && this.pattern.matcher(param1Element2.attr(this.key)).find());
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 264 */       return String.format("[%s~=%s]", new Object[] { this.key, this.pattern.toString() });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class AttributeKeyPair
/*     */     extends Evaluator
/*     */   {
/*     */     String key;
/*     */     
/*     */     String value;
/*     */     
/*     */     public AttributeKeyPair(String param1String1, String param1String2) {
/* 277 */       Validate.notEmpty(param1String1);
/* 278 */       Validate.notEmpty(param1String2);
/*     */       
/* 280 */       this.key = param1String1.trim().toLowerCase();
/* 281 */       if (param1String2.startsWith("\"") && param1String2.endsWith("\"")) {
/* 282 */         param1String2 = param1String2.substring(1, param1String2.length() - 1);
/*     */       }
/* 284 */       this.value = param1String2.trim().toLowerCase();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AllElements
/*     */     extends Evaluator
/*     */   {
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 295 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 300 */       return "*";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class IndexLessThan
/*     */     extends IndexEvaluator
/*     */   {
/*     */     public IndexLessThan(int param1Int) {
/* 309 */       super(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 314 */       return (param1Element2.elementSiblingIndex().intValue() < this.index);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 319 */       return String.format(":lt(%d)", new Object[] { Integer.valueOf(this.index) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IndexGreaterThan
/*     */     extends IndexEvaluator
/*     */   {
/*     */     public IndexGreaterThan(int param1Int) {
/* 329 */       super(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 334 */       return (param1Element2.elementSiblingIndex().intValue() > this.index);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 339 */       return String.format(":gt(%d)", new Object[] { Integer.valueOf(this.index) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IndexEquals
/*     */     extends IndexEvaluator
/*     */   {
/*     */     public IndexEquals(int param1Int) {
/* 349 */       super(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 354 */       return (param1Element2.elementSiblingIndex().intValue() == this.index);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 359 */       return String.format(":eq(%d)", new Object[] { Integer.valueOf(this.index) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IsLastChild
/*     */     extends Evaluator
/*     */   {
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 370 */       Element element = param1Element2.parent();
/* 371 */       return (element != null && !(element instanceof org.jsoup.nodes.Document) && param1Element2.elementSiblingIndex().intValue() == element.children().size() - 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 376 */       return ":last-child";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class IsFirstOfType extends IsNthOfType {
/*     */     public IsFirstOfType() {
/* 382 */       super(0, 1);
/*     */     }
/*     */     
/*     */     public String toString() {
/* 386 */       return ":first-of-type";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class IsLastOfType extends IsNthLastOfType {
/*     */     public IsLastOfType() {
/* 392 */       super(0, 1);
/*     */     }
/*     */     
/*     */     public String toString() {
/* 396 */       return ":last-of-type";
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class CssNthEvaluator extends Evaluator {
/*     */     protected final int a;
/*     */     protected final int b;
/*     */     
/*     */     public CssNthEvaluator(int param1Int1, int param1Int2) {
/* 405 */       this.a = param1Int1;
/* 406 */       this.b = param1Int2;
/*     */     }
/*     */     public CssNthEvaluator(int param1Int) {
/* 409 */       this(0, param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 414 */       Element element = param1Element2.parent();
/* 415 */       if (element == null || element instanceof org.jsoup.nodes.Document) return false;
/*     */       
/* 417 */       int i = calculatePosition(param1Element1, param1Element2);
/* 418 */       if (this.a == 0) return (i == this.b);
/*     */       
/* 420 */       return ((i - this.b) * this.a >= 0 && (i - this.b) % this.a == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 425 */       if (this.a == 0)
/* 426 */         return String.format(":%s(%d)", new Object[] { getPseudoClass(), Integer.valueOf(this.b) }); 
/* 427 */       if (this.b == 0)
/* 428 */         return String.format(":%s(%dn)", new Object[] { getPseudoClass(), Integer.valueOf(this.a) }); 
/* 429 */       return String.format(":%s(%dn%+d)", new Object[] { getPseudoClass(), Integer.valueOf(this.a), Integer.valueOf(this.b) });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract String getPseudoClass();
/*     */ 
/*     */     
/*     */     protected abstract int calculatePosition(Element param1Element1, Element param1Element2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class IsNthChild
/*     */     extends CssNthEvaluator
/*     */   {
/*     */     public IsNthChild(int param1Int1, int param1Int2) {
/* 445 */       super(param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     protected int calculatePosition(Element param1Element1, Element param1Element2) {
/* 449 */       return param1Element2.elementSiblingIndex().intValue() + 1;
/*     */     }
/*     */ 
/*     */     
/*     */     protected String getPseudoClass() {
/* 454 */       return "nth-child";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IsNthLastChild
/*     */     extends CssNthEvaluator
/*     */   {
/*     */     public IsNthLastChild(int param1Int1, int param1Int2) {
/* 465 */       super(param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int calculatePosition(Element param1Element1, Element param1Element2) {
/* 470 */       return param1Element2.parent().children().size() - param1Element2.elementSiblingIndex().intValue();
/*     */     }
/*     */ 
/*     */     
/*     */     protected String getPseudoClass() {
/* 475 */       return "nth-last-child";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IsNthOfType
/*     */     extends CssNthEvaluator
/*     */   {
/*     */     public IsNthOfType(int param1Int1, int param1Int2) {
/* 485 */       super(param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     protected int calculatePosition(Element param1Element1, Element param1Element2) {
/* 489 */       byte b1 = 0;
/* 490 */       Elements elements = param1Element2.parent().children();
/* 491 */       for (byte b2 = 0; b2 < elements.size(); b2++) {
/* 492 */         if (elements.get(b2).tag().equals(param1Element2.tag())) b1++; 
/* 493 */         if (elements.get(b2) == param1Element2)
/*     */           break; 
/* 495 */       }  return b1;
/*     */     }
/*     */ 
/*     */     
/*     */     protected String getPseudoClass() {
/* 500 */       return "nth-of-type";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class IsNthLastOfType
/*     */     extends CssNthEvaluator {
/*     */     public IsNthLastOfType(int param1Int1, int param1Int2) {
/* 507 */       super(param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int calculatePosition(Element param1Element1, Element param1Element2) {
/* 512 */       byte b = 0;
/* 513 */       Elements elements = param1Element2.parent().children();
/* 514 */       for (int i = param1Element2.elementSiblingIndex().intValue(); i < elements.size(); i++) {
/* 515 */         if (elements.get(i).tag().equals(param1Element2.tag())) b++; 
/*     */       } 
/* 517 */       return b;
/*     */     }
/*     */ 
/*     */     
/*     */     protected String getPseudoClass() {
/* 522 */       return "nth-last-of-type";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IsFirstChild
/*     */     extends Evaluator
/*     */   {
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 532 */       Element element = param1Element2.parent();
/* 533 */       return (element != null && !(element instanceof org.jsoup.nodes.Document) && param1Element2.elementSiblingIndex().intValue() == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 538 */       return ":first-child";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IsRoot
/*     */     extends Evaluator
/*     */   {
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 550 */       Element element = (param1Element1 instanceof org.jsoup.nodes.Document) ? param1Element1.child(0) : param1Element1;
/* 551 */       return (param1Element2 == element);
/*     */     }
/*     */     
/*     */     public String toString() {
/* 555 */       return ":root";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class IsOnlyChild
/*     */     extends Evaluator {
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 562 */       Element element = param1Element2.parent();
/* 563 */       return (element != null && !(element instanceof org.jsoup.nodes.Document) && param1Element2.siblingElements().size() == 0);
/*     */     }
/*     */     
/*     */     public String toString() {
/* 567 */       return ":only-child";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class IsOnlyOfType
/*     */     extends Evaluator {
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 574 */       Element element = param1Element2.parent();
/* 575 */       if (element == null || element instanceof org.jsoup.nodes.Document) return false;
/*     */       
/* 577 */       byte b1 = 0;
/* 578 */       Elements elements = element.children();
/* 579 */       for (byte b2 = 0; b2 < elements.size(); b2++) {
/* 580 */         if (elements.get(b2).tag().equals(param1Element2.tag())) b1++; 
/*     */       } 
/* 582 */       return (b1 == 1);
/*     */     }
/*     */     
/*     */     public String toString() {
/* 586 */       return ":only-of-type";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class IsEmpty
/*     */     extends Evaluator {
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 593 */       List<Node> list = param1Element2.childNodes();
/* 594 */       for (byte b = 0; b < list.size(); b++) {
/* 595 */         Node node = list.get(b);
/* 596 */         if (!(node instanceof org.jsoup.nodes.Comment) && !(node instanceof org.jsoup.nodes.XmlDeclaration) && !(node instanceof org.jsoup.nodes.DocumentType)) return false; 
/*     */       } 
/* 598 */       return true;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 602 */       return ":empty";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class IndexEvaluator
/*     */     extends Evaluator
/*     */   {
/*     */     int index;
/*     */ 
/*     */     
/*     */     public IndexEvaluator(int param1Int) {
/* 615 */       this.index = param1Int;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class ContainsText
/*     */     extends Evaluator
/*     */   {
/*     */     private String searchText;
/*     */     
/*     */     public ContainsText(String param1String) {
/* 626 */       this.searchText = param1String.toLowerCase();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 631 */       return param1Element2.text().toLowerCase().contains(this.searchText);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 636 */       return String.format(":contains(%s", new Object[] { this.searchText });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class ContainsOwnText
/*     */     extends Evaluator
/*     */   {
/*     */     private String searchText;
/*     */     
/*     */     public ContainsOwnText(String param1String) {
/* 647 */       this.searchText = param1String.toLowerCase();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 652 */       return param1Element2.ownText().toLowerCase().contains(this.searchText);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 657 */       return String.format(":containsOwn(%s", new Object[] { this.searchText });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Matches
/*     */     extends Evaluator
/*     */   {
/*     */     private Pattern pattern;
/*     */     
/*     */     public Matches(Pattern param1Pattern) {
/* 668 */       this.pattern = param1Pattern;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 673 */       Matcher matcher = this.pattern.matcher(param1Element2.text());
/* 674 */       return matcher.find();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 679 */       return String.format(":matches(%s", new Object[] { this.pattern });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class MatchesOwn
/*     */     extends Evaluator
/*     */   {
/*     */     private Pattern pattern;
/*     */     
/*     */     public MatchesOwn(Pattern param1Pattern) {
/* 690 */       this.pattern = param1Pattern;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 695 */       Matcher matcher = this.pattern.matcher(param1Element2.ownText());
/* 696 */       return matcher.find();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 701 */       return String.format(":matchesOwn(%s", new Object[] { this.pattern });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\select\Evaluator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */