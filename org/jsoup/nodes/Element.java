/*      */ package org.jsoup.nodes;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.regex.Pattern;
/*      */ import java.util.regex.PatternSyntaxException;
/*      */ import org.jsoup.helper.StringUtil;
/*      */ import org.jsoup.helper.Validate;
/*      */ import org.jsoup.parser.Parser;
/*      */ import org.jsoup.parser.Tag;
/*      */ import org.jsoup.select.Collector;
/*      */ import org.jsoup.select.Elements;
/*      */ import org.jsoup.select.Evaluator;
/*      */ import org.jsoup.select.NodeTraversor;
/*      */ import org.jsoup.select.NodeVisitor;
/*      */ import org.jsoup.select.Selector;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Element
/*      */   extends Node
/*      */ {
/*      */   private Tag tag;
/*      */   private Set<String> classNames;
/*      */   
/*      */   public Element(Tag paramTag, String paramString, Attributes paramAttributes) {
/*   35 */     super(paramString, paramAttributes);
/*      */     
/*   37 */     Validate.notNull(paramTag);
/*   38 */     this.tag = paramTag;
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
/*      */   public Element(Tag paramTag, String paramString) {
/*   50 */     this(paramTag, paramString, new Attributes());
/*      */   }
/*      */ 
/*      */   
/*      */   public String nodeName() {
/*   55 */     return this.tag.getName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String tagName() {
/*   64 */     return this.tag.getName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element tagName(String paramString) {
/*   75 */     Validate.notEmpty(paramString, "Tag name must not be empty.");
/*   76 */     this.tag = Tag.valueOf(paramString);
/*   77 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Tag tag() {
/*   86 */     return this.tag;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBlock() {
/*   96 */     return this.tag.isBlock();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String id() {
/*  105 */     String str = attr("id");
/*  106 */     return (str == null) ? "" : str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element attr(String paramString1, String paramString2) {
/*  116 */     super.attr(paramString1, paramString2);
/*  117 */     return this;
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
/*      */   public Map<String, String> dataset() {
/*  134 */     return this.attributes.dataset();
/*      */   }
/*      */ 
/*      */   
/*      */   public final Element parent() {
/*  139 */     return (Element)this.parentNode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements parents() {
/*  147 */     Elements elements = new Elements();
/*  148 */     accumulateParents(this, elements);
/*  149 */     return elements;
/*      */   }
/*      */   
/*      */   private static void accumulateParents(Element paramElement, Elements paramElements) {
/*  153 */     Element element = paramElement.parent();
/*  154 */     if (element != null && !element.tagName().equals("#root")) {
/*  155 */       paramElements.add(element);
/*  156 */       accumulateParents(element, paramElements);
/*      */     } 
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
/*      */   public Element child(int paramInt) {
/*  171 */     return children().get(paramInt);
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
/*      */   public Elements children() {
/*  184 */     ArrayList<Element> arrayList = new ArrayList(this.childNodes.size());
/*  185 */     for (Node node : this.childNodes) {
/*  186 */       if (node instanceof Element)
/*  187 */         arrayList.add((Element)node); 
/*      */     } 
/*  189 */     return new Elements(arrayList);
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
/*      */   public List<TextNode> textNodes() {
/*  209 */     ArrayList<TextNode> arrayList = new ArrayList();
/*  210 */     for (Node node : this.childNodes) {
/*  211 */       if (node instanceof TextNode)
/*  212 */         arrayList.add((TextNode)node); 
/*      */     } 
/*  214 */     return Collections.unmodifiableList(arrayList);
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
/*      */   public List<DataNode> dataNodes() {
/*  226 */     ArrayList<DataNode> arrayList = new ArrayList();
/*  227 */     for (Node node : this.childNodes) {
/*  228 */       if (node instanceof DataNode)
/*  229 */         arrayList.add((DataNode)node); 
/*      */     } 
/*  231 */     return Collections.unmodifiableList(arrayList);
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
/*      */   public Elements select(String paramString) {
/*  252 */     return Selector.select(paramString, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element appendChild(Node paramNode) {
/*  262 */     Validate.notNull(paramNode);
/*      */     
/*  264 */     addChildren(new Node[] { paramNode });
/*  265 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element prependChild(Node paramNode) {
/*  275 */     Validate.notNull(paramNode);
/*      */     
/*  277 */     addChildren(0, new Node[] { paramNode });
/*  278 */     return this;
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
/*      */   public Element insertChildren(int paramInt, Collection<? extends Node> paramCollection) {
/*  292 */     Validate.notNull(paramCollection, "Children collection to be inserted must not be null.");
/*  293 */     int i = childNodeSize();
/*  294 */     if (paramInt < 0) paramInt += i + 1; 
/*  295 */     Validate.isTrue((paramInt >= 0 && paramInt <= i), "Insert position out of bounds.");
/*      */     
/*  297 */     ArrayList<Node> arrayList = new ArrayList<Node>(paramCollection);
/*  298 */     Node[] arrayOfNode = arrayList.<Node>toArray(new Node[arrayList.size()]);
/*  299 */     addChildren(paramInt, arrayOfNode);
/*  300 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element appendElement(String paramString) {
/*  311 */     Element element = new Element(Tag.valueOf(paramString), baseUri());
/*  312 */     appendChild(element);
/*  313 */     return element;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element prependElement(String paramString) {
/*  324 */     Element element = new Element(Tag.valueOf(paramString), baseUri());
/*  325 */     prependChild(element);
/*  326 */     return element;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element appendText(String paramString) {
/*  336 */     TextNode textNode = new TextNode(paramString, baseUri());
/*  337 */     appendChild(textNode);
/*  338 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element prependText(String paramString) {
/*  348 */     TextNode textNode = new TextNode(paramString, baseUri());
/*  349 */     prependChild(textNode);
/*  350 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element append(String paramString) {
/*  360 */     Validate.notNull(paramString);
/*      */     
/*  362 */     List list = Parser.parseFragment(paramString, this, baseUri());
/*  363 */     addChildren((Node[])list.toArray((Object[])new Node[list.size()]));
/*  364 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element prepend(String paramString) {
/*  374 */     Validate.notNull(paramString);
/*      */     
/*  376 */     List list = Parser.parseFragment(paramString, this, baseUri());
/*  377 */     addChildren(0, (Node[])list.toArray((Object[])new Node[list.size()]));
/*  378 */     return this;
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
/*      */   public Element before(String paramString) {
/*  390 */     return (Element)super.before(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element before(Node paramNode) {
/*  401 */     return (Element)super.before(paramNode);
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
/*      */   public Element after(String paramString) {
/*  413 */     return (Element)super.after(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element after(Node paramNode) {
/*  424 */     return (Element)super.after(paramNode);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element empty() {
/*  432 */     this.childNodes.clear();
/*  433 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element wrap(String paramString) {
/*  444 */     return (Element)super.wrap(paramString);
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
/*      */   public String cssSelector() {
/*  456 */     if (id().length() > 0) {
/*  457 */       return "#" + id();
/*      */     }
/*  459 */     StringBuilder stringBuilder = new StringBuilder(tagName());
/*  460 */     String str = StringUtil.join(classNames(), ".");
/*  461 */     if (str.length() > 0) {
/*  462 */       stringBuilder.append('.').append(str);
/*      */     }
/*  464 */     if (parent() == null || parent() instanceof Document) {
/*  465 */       return stringBuilder.toString();
/*      */     }
/*  467 */     stringBuilder.insert(0, " > ");
/*  468 */     if (parent().select(stringBuilder.toString()).size() > 1) {
/*  469 */       stringBuilder.append(String.format(":nth-child(%d)", new Object[] { Integer.valueOf(elementSiblingIndex().intValue() + 1) }));
/*      */     }
/*      */     
/*  472 */     return parent().cssSelector() + stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements siblingElements() {
/*  481 */     if (this.parentNode == null) {
/*  482 */       return new Elements(0);
/*      */     }
/*  484 */     Elements elements1 = parent().children();
/*  485 */     Elements elements2 = new Elements(elements1.size() - 1);
/*  486 */     for (Element element : elements1) {
/*  487 */       if (element != this)
/*  488 */         elements2.add(element); 
/*  489 */     }  return elements2;
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
/*      */   public Element nextElementSibling() {
/*  501 */     if (this.parentNode == null) return null; 
/*  502 */     Elements<Element> elements = parent().children();
/*  503 */     Integer integer = indexInList(this, (List<Element>)elements);
/*  504 */     Validate.notNull(integer);
/*  505 */     if (elements.size() > integer.intValue() + 1) {
/*  506 */       return elements.get(integer.intValue() + 1);
/*      */     }
/*  508 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element previousElementSibling() {
/*  517 */     if (this.parentNode == null) return null; 
/*  518 */     Elements<Element> elements = parent().children();
/*  519 */     Integer integer = indexInList(this, (List<Element>)elements);
/*  520 */     Validate.notNull(integer);
/*  521 */     if (integer.intValue() > 0) {
/*  522 */       return elements.get(integer.intValue() - 1);
/*      */     }
/*  524 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element firstElementSibling() {
/*  533 */     Elements<Element> elements = parent().children();
/*  534 */     return (elements.size() > 1) ? elements.get(0) : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Integer elementSiblingIndex() {
/*  543 */     if (parent() == null) return Integer.valueOf(0); 
/*  544 */     return indexInList(this, (List<Element>)parent().children());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element lastElementSibling() {
/*  552 */     Elements<Element> elements = parent().children();
/*  553 */     return (elements.size() > 1) ? elements.get(elements.size() - 1) : null;
/*      */   }
/*      */   
/*      */   private static <E extends Element> Integer indexInList(Element paramElement, List<E> paramList) {
/*  557 */     Validate.notNull(paramElement);
/*  558 */     Validate.notNull(paramList);
/*      */     
/*  560 */     for (byte b = 0; b < paramList.size(); b++) {
/*  561 */       Element element = (Element)paramList.get(b);
/*  562 */       if (element.equals(paramElement))
/*  563 */         return Integer.valueOf(b); 
/*      */     } 
/*  565 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByTag(String paramString) {
/*  576 */     Validate.notEmpty(paramString);
/*  577 */     paramString = paramString.toLowerCase().trim();
/*      */     
/*  579 */     return Collector.collect((Evaluator)new Evaluator.Tag(paramString), this);
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
/*      */   public Element getElementById(String paramString) {
/*  592 */     Validate.notEmpty(paramString);
/*      */     
/*  594 */     Elements elements = Collector.collect((Evaluator)new Evaluator.Id(paramString), this);
/*  595 */     if (elements.size() > 0) {
/*  596 */       return elements.get(0);
/*      */     }
/*  598 */     return null;
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
/*      */   public Elements getElementsByClass(String paramString) {
/*  613 */     Validate.notEmpty(paramString);
/*      */     
/*  615 */     return Collector.collect((Evaluator)new Evaluator.Class(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttribute(String paramString) {
/*  625 */     Validate.notEmpty(paramString);
/*  626 */     paramString = paramString.trim().toLowerCase();
/*      */     
/*  628 */     return Collector.collect((Evaluator)new Evaluator.Attribute(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeStarting(String paramString) {
/*  638 */     Validate.notEmpty(paramString);
/*  639 */     paramString = paramString.trim().toLowerCase();
/*      */     
/*  641 */     return Collector.collect((Evaluator)new Evaluator.AttributeStarting(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValue(String paramString1, String paramString2) {
/*  652 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValue(paramString1, paramString2), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueNot(String paramString1, String paramString2) {
/*  663 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValueNot(paramString1, paramString2), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueStarting(String paramString1, String paramString2) {
/*  674 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValueStarting(paramString1, paramString2), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueEnding(String paramString1, String paramString2) {
/*  685 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValueEnding(paramString1, paramString2), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueContaining(String paramString1, String paramString2) {
/*  696 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValueContaining(paramString1, paramString2), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueMatching(String paramString, Pattern paramPattern) {
/*  706 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValueMatching(paramString, paramPattern), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueMatching(String paramString1, String paramString2) {
/*      */     Pattern pattern;
/*      */     try {
/*  719 */       pattern = Pattern.compile(paramString2);
/*  720 */     } catch (PatternSyntaxException patternSyntaxException) {
/*  721 */       throw new IllegalArgumentException("Pattern syntax error: " + paramString2, patternSyntaxException);
/*      */     } 
/*  723 */     return getElementsByAttributeValueMatching(paramString1, pattern);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByIndexLessThan(int paramInt) {
/*  732 */     return Collector.collect((Evaluator)new Evaluator.IndexLessThan(paramInt), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByIndexGreaterThan(int paramInt) {
/*  741 */     return Collector.collect((Evaluator)new Evaluator.IndexGreaterThan(paramInt), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByIndexEquals(int paramInt) {
/*  750 */     return Collector.collect((Evaluator)new Evaluator.IndexEquals(paramInt), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsContainingText(String paramString) {
/*  761 */     return Collector.collect((Evaluator)new Evaluator.ContainsText(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsContainingOwnText(String paramString) {
/*  772 */     return Collector.collect((Evaluator)new Evaluator.ContainsOwnText(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsMatchingText(Pattern paramPattern) {
/*  782 */     return Collector.collect((Evaluator)new Evaluator.Matches(paramPattern), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsMatchingText(String paramString) {
/*      */     Pattern pattern;
/*      */     try {
/*  794 */       pattern = Pattern.compile(paramString);
/*  795 */     } catch (PatternSyntaxException patternSyntaxException) {
/*  796 */       throw new IllegalArgumentException("Pattern syntax error: " + paramString, patternSyntaxException);
/*      */     } 
/*  798 */     return getElementsMatchingText(pattern);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsMatchingOwnText(Pattern paramPattern) {
/*  808 */     return Collector.collect((Evaluator)new Evaluator.MatchesOwn(paramPattern), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsMatchingOwnText(String paramString) {
/*      */     Pattern pattern;
/*      */     try {
/*  820 */       pattern = Pattern.compile(paramString);
/*  821 */     } catch (PatternSyntaxException patternSyntaxException) {
/*  822 */       throw new IllegalArgumentException("Pattern syntax error: " + paramString, patternSyntaxException);
/*      */     } 
/*  824 */     return getElementsMatchingOwnText(pattern);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getAllElements() {
/*  833 */     return Collector.collect((Evaluator)new Evaluator.AllElements(), this);
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
/*      */   public String text() {
/*  846 */     final StringBuilder accum = new StringBuilder();
/*  847 */     (new NodeTraversor(new NodeVisitor() {
/*      */           public void head(Node param1Node, int param1Int) {
/*  849 */             if (param1Node instanceof TextNode) {
/*  850 */               TextNode textNode = (TextNode)param1Node;
/*  851 */               Element.appendNormalisedText(accum, textNode);
/*  852 */             } else if (param1Node instanceof Element) {
/*  853 */               Element element = (Element)param1Node;
/*  854 */               if (accum.length() > 0 && (element.isBlock() || element.tag.getName().equals("br")) && !TextNode.lastCharIsWhitespace(accum))
/*      */               {
/*      */                 
/*  857 */                 accum.append(" ");
/*      */               }
/*      */             } 
/*      */           }
/*      */           
/*      */           public void tail(Node param1Node, int param1Int) {}
/*      */         })).traverse(this);
/*  864 */     return stringBuilder.toString().trim();
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
/*      */   public String ownText() {
/*  879 */     StringBuilder stringBuilder = new StringBuilder();
/*  880 */     ownText(stringBuilder);
/*  881 */     return stringBuilder.toString().trim();
/*      */   }
/*      */   
/*      */   private void ownText(StringBuilder paramStringBuilder) {
/*  885 */     for (Node node : this.childNodes) {
/*  886 */       if (node instanceof TextNode) {
/*  887 */         TextNode textNode = (TextNode)node;
/*  888 */         appendNormalisedText(paramStringBuilder, textNode); continue;
/*  889 */       }  if (node instanceof Element) {
/*  890 */         appendWhitespaceIfBr((Element)node, paramStringBuilder);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void appendNormalisedText(StringBuilder paramStringBuilder, TextNode paramTextNode) {
/*  896 */     String str = paramTextNode.getWholeText();
/*      */     
/*  898 */     if (preserveWhitespace(paramTextNode.parentNode)) {
/*  899 */       paramStringBuilder.append(str);
/*      */     } else {
/*  901 */       StringUtil.appendNormalisedWhitespace(paramStringBuilder, str, TextNode.lastCharIsWhitespace(paramStringBuilder));
/*      */     } 
/*      */   }
/*      */   private static void appendWhitespaceIfBr(Element paramElement, StringBuilder paramStringBuilder) {
/*  905 */     if (paramElement.tag.getName().equals("br") && !TextNode.lastCharIsWhitespace(paramStringBuilder)) {
/*  906 */       paramStringBuilder.append(" ");
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean preserveWhitespace(Node paramNode) {
/*  911 */     if (paramNode != null && paramNode instanceof Element) {
/*  912 */       Element element = (Element)paramNode;
/*  913 */       return (element.tag.preserveWhitespace() || (element.parent() != null && (element.parent()).tag.preserveWhitespace()));
/*      */     } 
/*      */     
/*  916 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element text(String paramString) {
/*  925 */     Validate.notNull(paramString);
/*      */     
/*  927 */     empty();
/*  928 */     TextNode textNode = new TextNode(paramString, this.baseUri);
/*  929 */     appendChild(textNode);
/*      */     
/*  931 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasText() {
/*  939 */     for (Node node : this.childNodes) {
/*  940 */       if (node instanceof TextNode) {
/*  941 */         TextNode textNode = (TextNode)node;
/*  942 */         if (!textNode.isBlank())
/*  943 */           return true;  continue;
/*  944 */       }  if (node instanceof Element) {
/*  945 */         Element element = (Element)node;
/*  946 */         if (element.hasText())
/*  947 */           return true; 
/*      */       } 
/*      */     } 
/*  950 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String data() {
/*  960 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/*  962 */     for (Node node : this.childNodes) {
/*  963 */       if (node instanceof DataNode) {
/*  964 */         DataNode dataNode = (DataNode)node;
/*  965 */         stringBuilder.append(dataNode.getWholeData()); continue;
/*  966 */       }  if (node instanceof Element) {
/*  967 */         Element element = (Element)node;
/*  968 */         String str = element.data();
/*  969 */         stringBuilder.append(str);
/*      */       } 
/*      */     } 
/*  972 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String className() {
/*  981 */     return attr("class");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> classNames() {
/*  991 */     if (this.classNames == null) {
/*  992 */       String[] arrayOfString = className().split("\\s+");
/*  993 */       this.classNames = new LinkedHashSet<String>(Arrays.asList(arrayOfString));
/*      */     } 
/*  995 */     return this.classNames;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element classNames(Set<String> paramSet) {
/* 1004 */     Validate.notNull(paramSet);
/* 1005 */     this.attributes.put("class", StringUtil.join(paramSet, " "));
/* 1006 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasClass(String paramString) {
/* 1015 */     Set<String> set = classNames();
/* 1016 */     for (String str : set) {
/* 1017 */       if (paramString.equalsIgnoreCase(str))
/* 1018 */         return true; 
/*      */     } 
/* 1020 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element addClass(String paramString) {
/* 1029 */     Validate.notNull(paramString);
/*      */     
/* 1031 */     Set<String> set = classNames();
/* 1032 */     set.add(paramString);
/* 1033 */     classNames(set);
/*      */     
/* 1035 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element removeClass(String paramString) {
/* 1044 */     Validate.notNull(paramString);
/*      */     
/* 1046 */     Set<String> set = classNames();
/* 1047 */     set.remove(paramString);
/* 1048 */     classNames(set);
/*      */     
/* 1050 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element toggleClass(String paramString) {
/* 1059 */     Validate.notNull(paramString);
/*      */     
/* 1061 */     Set<String> set = classNames();
/* 1062 */     if (set.contains(paramString)) {
/* 1063 */       set.remove(paramString);
/*      */     } else {
/* 1065 */       set.add(paramString);
/* 1066 */     }  classNames(set);
/*      */     
/* 1068 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String val() {
/* 1076 */     if (tagName().equals("textarea")) {
/* 1077 */       return text();
/*      */     }
/* 1079 */     return attr("value");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element val(String paramString) {
/* 1088 */     if (tagName().equals("textarea")) {
/* 1089 */       text(paramString);
/*      */     } else {
/* 1091 */       attr("value", paramString);
/* 1092 */     }  return this;
/*      */   }
/*      */   
/*      */   void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 1096 */     if (paramStringBuilder.length() > 0 && paramOutputSettings.prettyPrint() && (this.tag.formatAsBlock() || (parent() != null && parent().tag().formatAsBlock()) || paramOutputSettings.outline()))
/* 1097 */       indent(paramStringBuilder, paramInt, paramOutputSettings); 
/* 1098 */     paramStringBuilder.append("<").append(tagName());
/*      */ 
/*      */     
/* 1101 */     this.attributes.html(paramStringBuilder, paramOutputSettings);
/*      */ 
/*      */     
/* 1104 */     if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
/* 1105 */       if (paramOutputSettings.syntax() == Document.OutputSettings.Syntax.html && this.tag.isEmpty()) {
/* 1106 */         paramStringBuilder.append('>');
/*      */       } else {
/* 1108 */         paramStringBuilder.append(" />");
/*      */       } 
/*      */     } else {
/* 1111 */       paramStringBuilder.append(">");
/*      */     } 
/*      */   }
/*      */   void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 1115 */     if (!this.childNodes.isEmpty() || !this.tag.isSelfClosing()) {
/* 1116 */       if (paramOutputSettings.prettyPrint() && !this.childNodes.isEmpty() && (this.tag.formatAsBlock() || (paramOutputSettings.outline() && (this.childNodes.size() > 1 || (this.childNodes.size() == 1 && !(this.childNodes.get(0) instanceof TextNode))))))
/*      */       {
/*      */         
/* 1119 */         indent(paramStringBuilder, paramInt, paramOutputSettings); } 
/* 1120 */       paramStringBuilder.append("</").append(tagName()).append(">");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String html() {
/* 1132 */     StringBuilder stringBuilder = new StringBuilder();
/* 1133 */     html(stringBuilder);
/* 1134 */     return getOutputSettings().prettyPrint() ? stringBuilder.toString().trim() : stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private void html(StringBuilder paramStringBuilder) {
/* 1138 */     for (Node node : this.childNodes) {
/* 1139 */       node.outerHtml(paramStringBuilder);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element html(String paramString) {
/* 1149 */     empty();
/* 1150 */     append(paramString);
/* 1151 */     return this;
/*      */   }
/*      */   
/*      */   public String toString() {
/* 1155 */     return outerHtml();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 1160 */     return (this == paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1166 */     int i = super.hashCode();
/* 1167 */     i = 31 * i + ((this.tag != null) ? this.tag.hashCode() : 0);
/* 1168 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public Element clone() {
/* 1173 */     Element element = (Element)super.clone();
/* 1174 */     element.classNames = null;
/* 1175 */     return element;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\Element.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */