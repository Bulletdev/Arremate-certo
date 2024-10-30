/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.jsoup.helper.StringUtil;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.parser.Parser;
/*     */ import org.jsoup.select.Elements;
/*     */ import org.jsoup.select.NodeTraversor;
/*     */ import org.jsoup.select.NodeVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Node
/*     */   implements Cloneable
/*     */ {
/*     */   Node parentNode;
/*     */   List<Node> childNodes;
/*     */   Attributes attributes;
/*     */   String baseUri;
/*     */   int siblingIndex;
/*     */   
/*     */   protected Node(String paramString, Attributes paramAttributes) {
/*  33 */     Validate.notNull(paramString);
/*  34 */     Validate.notNull(paramAttributes);
/*     */     
/*  36 */     this.childNodes = new ArrayList<Node>(4);
/*  37 */     this.baseUri = paramString.trim();
/*  38 */     this.attributes = paramAttributes;
/*     */   }
/*     */   
/*     */   protected Node(String paramString) {
/*  42 */     this(paramString, new Attributes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Node() {
/*  49 */     this.childNodes = Collections.emptyList();
/*  50 */     this.attributes = null;
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
/*     */   
/*     */   public String attr(String paramString) {
/*  72 */     Validate.notNull(paramString);
/*     */     
/*  74 */     if (this.attributes.hasKey(paramString))
/*  75 */       return this.attributes.get(paramString); 
/*  76 */     if (paramString.toLowerCase().startsWith("abs:"))
/*  77 */       return absUrl(paramString.substring("abs:".length())); 
/*  78 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes attributes() {
/*  86 */     return this.attributes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node attr(String paramString1, String paramString2) {
/*  96 */     this.attributes.put(paramString1, paramString2);
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAttr(String paramString) {
/* 106 */     Validate.notNull(paramString);
/*     */     
/* 108 */     if (paramString.startsWith("abs:")) {
/* 109 */       String str = paramString.substring("abs:".length());
/* 110 */       if (this.attributes.hasKey(str) && !absUrl(str).equals(""))
/* 111 */         return true; 
/*     */     } 
/* 113 */     return this.attributes.hasKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node removeAttr(String paramString) {
/* 122 */     Validate.notNull(paramString);
/* 123 */     this.attributes.remove(paramString);
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String baseUri() {
/* 132 */     return this.baseUri;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseUri(final String baseUri) {
/* 140 */     Validate.notNull(baseUri);
/*     */     
/* 142 */     traverse(new NodeVisitor() {
/*     */           public void head(Node param1Node, int param1Int) {
/* 144 */             param1Node.baseUri = baseUri;
/*     */           }
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
/*     */           public void tail(Node param1Node, int param1Int) {}
/*     */         });
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
/*     */   public String absUrl(String paramString) {
/* 173 */     Validate.notEmpty(paramString);
/*     */     
/* 175 */     String str = attr(paramString);
/* 176 */     if (!hasAttr(paramString)) {
/* 177 */       return "";
/*     */     }
/*     */     try {
/*     */       URL uRL1;
/*     */       try {
/* 182 */         uRL1 = new URL(this.baseUri);
/* 183 */       } catch (MalformedURLException malformedURLException) {
/*     */         
/* 185 */         URL uRL = new URL(str);
/* 186 */         return uRL.toExternalForm();
/*     */       } 
/*     */       
/* 189 */       if (str.startsWith("?"))
/* 190 */         str = uRL1.getPath() + str; 
/* 191 */       URL uRL2 = new URL(uRL1, str);
/* 192 */       return uRL2.toExternalForm();
/* 193 */     } catch (MalformedURLException malformedURLException) {
/* 194 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node childNode(int paramInt) {
/* 205 */     return this.childNodes.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Node> childNodes() {
/* 214 */     return Collections.unmodifiableList(this.childNodes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Node> childNodesCopy() {
/* 223 */     ArrayList<Node> arrayList = new ArrayList(this.childNodes.size());
/* 224 */     for (Node node : this.childNodes) {
/* 225 */       arrayList.add(node.clone());
/*     */     }
/* 227 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int childNodeSize() {
/* 235 */     return this.childNodes.size();
/*     */   }
/*     */   
/*     */   protected Node[] childNodesAsArray() {
/* 239 */     return this.childNodes.<Node>toArray(new Node[childNodeSize()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node parent() {
/* 247 */     return this.parentNode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Node parentNode() {
/* 255 */     return this.parentNode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Document ownerDocument() {
/* 263 */     if (this instanceof Document)
/* 264 */       return (Document)this; 
/* 265 */     if (this.parentNode == null) {
/* 266 */       return null;
/*     */     }
/* 268 */     return this.parentNode.ownerDocument();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 275 */     Validate.notNull(this.parentNode);
/* 276 */     this.parentNode.removeChild(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node before(String paramString) {
/* 286 */     addSiblingHtml(siblingIndex(), paramString);
/* 287 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node before(Node paramNode) {
/* 297 */     Validate.notNull(paramNode);
/* 298 */     Validate.notNull(this.parentNode);
/*     */     
/* 300 */     this.parentNode.addChildren(siblingIndex(), new Node[] { paramNode });
/* 301 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node after(String paramString) {
/* 311 */     addSiblingHtml(siblingIndex() + 1, paramString);
/* 312 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node after(Node paramNode) {
/* 322 */     Validate.notNull(paramNode);
/* 323 */     Validate.notNull(this.parentNode);
/*     */     
/* 325 */     this.parentNode.addChildren(siblingIndex() + 1, new Node[] { paramNode });
/* 326 */     return this;
/*     */   }
/*     */   
/*     */   private void addSiblingHtml(int paramInt, String paramString) {
/* 330 */     Validate.notNull(paramString);
/* 331 */     Validate.notNull(this.parentNode);
/*     */     
/* 333 */     Element element = (parent() instanceof Element) ? (Element)parent() : null;
/* 334 */     List list = Parser.parseFragment(paramString, element, baseUri());
/* 335 */     this.parentNode.addChildren(paramInt, (Node[])list.toArray((Object[])new Node[list.size()]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node wrap(String paramString) {
/* 344 */     Validate.notEmpty(paramString);
/*     */     
/* 346 */     Element element1 = (parent() instanceof Element) ? (Element)parent() : null;
/* 347 */     List<Node> list = Parser.parseFragment(paramString, element1, baseUri());
/* 348 */     Node node = list.get(0);
/* 349 */     if (node == null || !(node instanceof Element)) {
/* 350 */       return null;
/*     */     }
/* 352 */     Element element2 = (Element)node;
/* 353 */     Element element3 = getDeepChild(element2);
/* 354 */     this.parentNode.replaceChild(this, element2);
/* 355 */     element3.addChildren(new Node[] { this });
/*     */ 
/*     */     
/* 358 */     if (list.size() > 0) {
/* 359 */       for (byte b = 0; b < list.size(); b++) {
/* 360 */         Node node1 = list.get(b);
/* 361 */         node1.parentNode.removeChild(node1);
/* 362 */         element2.appendChild(node1);
/*     */       } 
/*     */     }
/* 365 */     return this;
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
/*     */   public Node unwrap() {
/* 382 */     Validate.notNull(this.parentNode);
/*     */     
/* 384 */     int i = this.siblingIndex;
/* 385 */     Node node = (this.childNodes.size() > 0) ? this.childNodes.get(0) : null;
/* 386 */     this.parentNode.addChildren(i, childNodesAsArray());
/* 387 */     remove();
/*     */     
/* 389 */     return node;
/*     */   }
/*     */   
/*     */   private Element getDeepChild(Element paramElement) {
/* 393 */     Elements<Element> elements = paramElement.children();
/* 394 */     if (elements.size() > 0) {
/* 395 */       return getDeepChild(elements.get(0));
/*     */     }
/* 397 */     return paramElement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceWith(Node paramNode) {
/* 405 */     Validate.notNull(paramNode);
/* 406 */     Validate.notNull(this.parentNode);
/* 407 */     this.parentNode.replaceChild(this, paramNode);
/*     */   }
/*     */   
/*     */   protected void setParentNode(Node paramNode) {
/* 411 */     if (this.parentNode != null)
/* 412 */       this.parentNode.removeChild(this); 
/* 413 */     this.parentNode = paramNode;
/*     */   }
/*     */   
/*     */   protected void replaceChild(Node paramNode1, Node paramNode2) {
/* 417 */     Validate.isTrue((paramNode1.parentNode == this));
/* 418 */     Validate.notNull(paramNode2);
/* 419 */     if (paramNode2.parentNode != null) {
/* 420 */       paramNode2.parentNode.removeChild(paramNode2);
/*     */     }
/* 422 */     Integer integer = Integer.valueOf(paramNode1.siblingIndex());
/* 423 */     this.childNodes.set(integer.intValue(), paramNode2);
/* 424 */     paramNode2.parentNode = this;
/* 425 */     paramNode2.setSiblingIndex(integer.intValue());
/* 426 */     paramNode1.parentNode = null;
/*     */   }
/*     */   
/*     */   protected void removeChild(Node paramNode) {
/* 430 */     Validate.isTrue((paramNode.parentNode == this));
/* 431 */     int i = paramNode.siblingIndex();
/* 432 */     this.childNodes.remove(i);
/* 433 */     reindexChildren();
/* 434 */     paramNode.parentNode = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addChildren(Node... paramVarArgs) {
/* 439 */     for (Node node : paramVarArgs) {
/* 440 */       reparentChild(node);
/* 441 */       this.childNodes.add(node);
/* 442 */       node.setSiblingIndex(this.childNodes.size() - 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void addChildren(int paramInt, Node... paramVarArgs) {
/* 447 */     Validate.noNullElements((Object[])paramVarArgs);
/* 448 */     for (int i = paramVarArgs.length - 1; i >= 0; i--) {
/* 449 */       Node node = paramVarArgs[i];
/* 450 */       reparentChild(node);
/* 451 */       this.childNodes.add(paramInt, node);
/*     */     } 
/* 453 */     reindexChildren();
/*     */   }
/*     */   
/*     */   private void reparentChild(Node paramNode) {
/* 457 */     if (paramNode.parentNode != null)
/* 458 */       paramNode.parentNode.removeChild(paramNode); 
/* 459 */     paramNode.setParentNode(this);
/*     */   }
/*     */   
/*     */   private void reindexChildren() {
/* 463 */     for (byte b = 0; b < this.childNodes.size(); b++) {
/* 464 */       ((Node)this.childNodes.get(b)).setSiblingIndex(b);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Node> siblingNodes() {
/* 474 */     if (this.parentNode == null) {
/* 475 */       return Collections.emptyList();
/*     */     }
/* 477 */     List<Node> list = this.parentNode.childNodes;
/* 478 */     ArrayList<Node> arrayList = new ArrayList(list.size() - 1);
/* 479 */     for (Node node : list) {
/* 480 */       if (node != this)
/* 481 */         arrayList.add(node); 
/* 482 */     }  return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node nextSibling() {
/* 490 */     if (this.parentNode == null) {
/* 491 */       return null;
/*     */     }
/* 493 */     List<Node> list = this.parentNode.childNodes;
/* 494 */     Integer integer = Integer.valueOf(siblingIndex());
/* 495 */     Validate.notNull(integer);
/* 496 */     if (list.size() > integer.intValue() + 1) {
/* 497 */       return list.get(integer.intValue() + 1);
/*     */     }
/* 499 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node previousSibling() {
/* 507 */     if (this.parentNode == null) {
/* 508 */       return null;
/*     */     }
/* 510 */     List<Node> list = this.parentNode.childNodes;
/* 511 */     Integer integer = Integer.valueOf(siblingIndex());
/* 512 */     Validate.notNull(integer);
/* 513 */     if (integer.intValue() > 0) {
/* 514 */       return list.get(integer.intValue() - 1);
/*     */     }
/* 516 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int siblingIndex() {
/* 526 */     return this.siblingIndex;
/*     */   }
/*     */   
/*     */   protected void setSiblingIndex(int paramInt) {
/* 530 */     this.siblingIndex = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node traverse(NodeVisitor paramNodeVisitor) {
/* 539 */     Validate.notNull(paramNodeVisitor);
/* 540 */     NodeTraversor nodeTraversor = new NodeTraversor(paramNodeVisitor);
/* 541 */     nodeTraversor.traverse(this);
/* 542 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String outerHtml() {
/* 550 */     StringBuilder stringBuilder = new StringBuilder(128);
/* 551 */     outerHtml(stringBuilder);
/* 552 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   protected void outerHtml(StringBuilder paramStringBuilder) {
/* 556 */     (new NodeTraversor(new OuterHtmlVisitor(paramStringBuilder, getOutputSettings()))).traverse(this);
/*     */   }
/*     */ 
/*     */   
/*     */   Document.OutputSettings getOutputSettings() {
/* 561 */     return (ownerDocument() != null) ? ownerDocument().outputSettings() : (new Document("")).outputSettings();
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
/*     */   public String toString() {
/* 573 */     return outerHtml();
/*     */   }
/*     */   
/*     */   protected void indent(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 577 */     paramStringBuilder.append("\n").append(StringUtil.padding(paramInt * paramOutputSettings.indentAmount()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 582 */     if (this == paramObject) return true;
/*     */     
/* 584 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 589 */     int i = (this.parentNode != null) ? this.parentNode.hashCode() : 0;
/*     */     
/* 591 */     i = 31 * i + ((this.attributes != null) ? this.attributes.hashCode() : 0);
/* 592 */     return i;
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
/*     */   public Node clone() {
/* 605 */     Node node = doClone(null);
/*     */ 
/*     */     
/* 608 */     LinkedList<Node> linkedList = new LinkedList();
/* 609 */     linkedList.add(node);
/*     */     
/* 611 */     while (!linkedList.isEmpty()) {
/* 612 */       Node node1 = linkedList.remove();
/*     */       
/* 614 */       for (byte b = 0; b < node1.childNodes.size(); b++) {
/* 615 */         Node node2 = ((Node)node1.childNodes.get(b)).doClone(node1);
/* 616 */         node1.childNodes.set(b, node2);
/* 617 */         linkedList.add(node2);
/*     */       } 
/*     */     } 
/*     */     
/* 621 */     return node;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Node doClone(Node paramNode) {
/*     */     Node node;
/*     */     try {
/* 632 */       node = (Node)super.clone();
/* 633 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 634 */       throw new RuntimeException(cloneNotSupportedException);
/*     */     } 
/*     */     
/* 637 */     node.parentNode = paramNode;
/* 638 */     node.siblingIndex = (paramNode == null) ? 0 : this.siblingIndex;
/* 639 */     node.attributes = (this.attributes != null) ? this.attributes.clone() : null;
/* 640 */     node.baseUri = this.baseUri;
/* 641 */     node.childNodes = new ArrayList<Node>(this.childNodes.size());
/*     */     
/* 643 */     for (Node node1 : this.childNodes) {
/* 644 */       node.childNodes.add(node1);
/*     */     }
/* 646 */     return node;
/*     */   }
/*     */   public abstract String nodeName();
/*     */   abstract void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings);
/*     */   abstract void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings);
/*     */   private static class OuterHtmlVisitor implements NodeVisitor { private StringBuilder accum;
/*     */     
/*     */     OuterHtmlVisitor(StringBuilder param1StringBuilder, Document.OutputSettings param1OutputSettings) {
/* 654 */       this.accum = param1StringBuilder;
/* 655 */       this.out = param1OutputSettings;
/*     */     }
/*     */     private Document.OutputSettings out;
/*     */     public void head(Node param1Node, int param1Int) {
/* 659 */       param1Node.outerHtmlHead(this.accum, param1Int, this.out);
/*     */     }
/*     */     
/*     */     public void tail(Node param1Node, int param1Int) {
/* 663 */       if (!param1Node.nodeName().equals("#text"))
/* 664 */         param1Node.outerHtmlTail(this.accum, param1Int, this.out); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\Node.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */