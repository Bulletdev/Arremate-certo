/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.FormElement;
/*     */ import org.jsoup.nodes.Node;
/*     */ 
/*     */ public class Elements
/*     */   implements Cloneable, List<Element> {
/*     */   private List<Element> contents;
/*     */   
/*     */   public Elements() {
/*  20 */     this.contents = new ArrayList<Element>();
/*     */   }
/*     */   
/*     */   public Elements(int paramInt) {
/*  24 */     this.contents = new ArrayList<Element>(paramInt);
/*     */   }
/*     */   
/*     */   public Elements(Collection<Element> paramCollection) {
/*  28 */     this.contents = new ArrayList<Element>(paramCollection);
/*     */   }
/*     */   
/*     */   public Elements(List<Element> paramList) {
/*  32 */     this.contents = paramList;
/*     */   }
/*     */   
/*     */   public Elements(Element... paramVarArgs) {
/*  36 */     this(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements clone() {
/*     */     Elements elements;
/*     */     try {
/*  47 */       elements = (Elements)super.clone();
/*  48 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/*  49 */       throw new RuntimeException(cloneNotSupportedException);
/*     */     } 
/*  51 */     ArrayList<Element> arrayList = new ArrayList();
/*  52 */     elements.contents = arrayList;
/*     */     
/*  54 */     for (Element element : this.contents) {
/*  55 */       arrayList.add(element.clone());
/*     */     }
/*     */     
/*  58 */     return elements;
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
/*     */   public String attr(String paramString) {
/*  70 */     for (Element element : this.contents) {
/*  71 */       if (element.hasAttr(paramString))
/*  72 */         return element.attr(paramString); 
/*     */     } 
/*  74 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAttr(String paramString) {
/*  83 */     for (Element element : this.contents) {
/*  84 */       if (element.hasAttr(paramString))
/*  85 */         return true; 
/*     */     } 
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements attr(String paramString1, String paramString2) {
/*  97 */     for (Element element : this.contents) {
/*  98 */       element.attr(paramString1, paramString2);
/*     */     }
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements removeAttr(String paramString) {
/* 109 */     for (Element element : this.contents) {
/* 110 */       element.removeAttr(paramString);
/*     */     }
/* 112 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements addClass(String paramString) {
/* 121 */     for (Element element : this.contents) {
/* 122 */       element.addClass(paramString);
/*     */     }
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements removeClass(String paramString) {
/* 133 */     for (Element element : this.contents) {
/* 134 */       element.removeClass(paramString);
/*     */     }
/* 136 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements toggleClass(String paramString) {
/* 145 */     for (Element element : this.contents) {
/* 146 */       element.toggleClass(paramString);
/*     */     }
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasClass(String paramString) {
/* 157 */     for (Element element : this.contents) {
/* 158 */       if (element.hasClass(paramString))
/* 159 */         return true; 
/*     */     } 
/* 161 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String val() {
/* 170 */     if (size() > 0) {
/* 171 */       return first().val();
/*     */     }
/* 173 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements val(String paramString) {
/* 182 */     for (Element element : this.contents)
/* 183 */       element.val(paramString); 
/* 184 */     return this;
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
/*     */   public String text() {
/* 196 */     StringBuilder stringBuilder = new StringBuilder();
/* 197 */     for (Element element : this.contents) {
/* 198 */       if (stringBuilder.length() != 0)
/* 199 */         stringBuilder.append(" "); 
/* 200 */       stringBuilder.append(element.text());
/*     */     } 
/* 202 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public boolean hasText() {
/* 206 */     for (Element element : this.contents) {
/* 207 */       if (element.hasText())
/* 208 */         return true; 
/*     */     } 
/* 210 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String html() {
/* 220 */     StringBuilder stringBuilder = new StringBuilder();
/* 221 */     for (Element element : this.contents) {
/* 222 */       if (stringBuilder.length() != 0)
/* 223 */         stringBuilder.append("\n"); 
/* 224 */       stringBuilder.append(element.html());
/*     */     } 
/* 226 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String outerHtml() {
/* 236 */     StringBuilder stringBuilder = new StringBuilder();
/* 237 */     for (Element element : this.contents) {
/* 238 */       if (stringBuilder.length() != 0)
/* 239 */         stringBuilder.append("\n"); 
/* 240 */       stringBuilder.append(element.outerHtml());
/*     */     } 
/* 242 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 252 */     return outerHtml();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements tagName(String paramString) {
/* 263 */     for (Element element : this.contents) {
/* 264 */       element.tagName(paramString);
/*     */     }
/* 266 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements html(String paramString) {
/* 276 */     for (Element element : this.contents) {
/* 277 */       element.html(paramString);
/*     */     }
/* 279 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements prepend(String paramString) {
/* 289 */     for (Element element : this.contents) {
/* 290 */       element.prepend(paramString);
/*     */     }
/* 292 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements append(String paramString) {
/* 302 */     for (Element element : this.contents) {
/* 303 */       element.append(paramString);
/*     */     }
/* 305 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements before(String paramString) {
/* 315 */     for (Element element : this.contents) {
/* 316 */       element.before(paramString);
/*     */     }
/* 318 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements after(String paramString) {
/* 328 */     for (Element element : this.contents) {
/* 329 */       element.after(paramString);
/*     */     }
/* 331 */     return this;
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
/*     */   public Elements wrap(String paramString) {
/* 344 */     Validate.notEmpty(paramString);
/* 345 */     for (Element element : this.contents) {
/* 346 */       element.wrap(paramString);
/*     */     }
/* 348 */     return this;
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
/*     */   public Elements unwrap() {
/* 365 */     for (Element element : this.contents) {
/* 366 */       element.unwrap();
/*     */     }
/* 368 */     return this;
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
/*     */   public Elements empty() {
/* 383 */     for (Element element : this.contents) {
/* 384 */       element.empty();
/*     */     }
/* 386 */     return this;
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
/*     */   public Elements remove() {
/* 402 */     for (Element element : this.contents) {
/* 403 */       element.remove();
/*     */     }
/* 405 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements select(String paramString) {
/* 416 */     return Selector.select(paramString, this);
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
/*     */   public Elements not(String paramString) {
/* 430 */     Elements elements = Selector.select(paramString, this);
/* 431 */     return Selector.filterOut(this, elements);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements eq(int paramInt) {
/* 442 */     return (this.contents.size() > paramInt) ? new Elements(new Element[] { get(paramInt) }) : new Elements();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean is(String paramString) {
/* 451 */     Elements elements = select(paramString);
/* 452 */     return !elements.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements parents() {
/* 460 */     LinkedHashSet<Element> linkedHashSet = new LinkedHashSet();
/* 461 */     for (Element element : this.contents) {
/* 462 */       linkedHashSet.addAll(element.parents());
/*     */     }
/* 464 */     return new Elements(linkedHashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element first() {
/* 473 */     return this.contents.isEmpty() ? null : this.contents.get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element last() {
/* 481 */     return this.contents.isEmpty() ? null : this.contents.get(this.contents.size() - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements traverse(NodeVisitor paramNodeVisitor) {
/* 490 */     Validate.notNull(paramNodeVisitor);
/* 491 */     NodeTraversor nodeTraversor = new NodeTraversor(paramNodeVisitor);
/* 492 */     for (Element element : this.contents) {
/* 493 */       nodeTraversor.traverse((Node)element);
/*     */     }
/* 495 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FormElement> forms() {
/* 504 */     ArrayList<FormElement> arrayList = new ArrayList();
/* 505 */     for (Element element : this.contents) {
/* 506 */       if (element instanceof FormElement)
/* 507 */         arrayList.add((FormElement)element); 
/* 508 */     }  return arrayList;
/*     */   }
/*     */   
/*     */   public int size() {
/* 512 */     return this.contents.size();
/*     */   } public boolean isEmpty() {
/* 514 */     return this.contents.isEmpty();
/*     */   } public boolean contains(Object paramObject) {
/* 516 */     return this.contents.contains(paramObject);
/*     */   } public Iterator<Element> iterator() {
/* 518 */     return this.contents.iterator();
/*     */   } public Object[] toArray() {
/* 520 */     return this.contents.toArray();
/*     */   } public <T> T[] toArray(T[] paramArrayOfT) {
/* 522 */     return this.contents.toArray(paramArrayOfT);
/*     */   } public boolean add(Element paramElement) {
/* 524 */     return this.contents.add(paramElement);
/*     */   } public boolean remove(Object paramObject) {
/* 526 */     return this.contents.remove(paramObject);
/*     */   } public boolean containsAll(Collection<?> paramCollection) {
/* 528 */     return this.contents.containsAll(paramCollection);
/*     */   } public boolean addAll(Collection<? extends Element> paramCollection) {
/* 530 */     return this.contents.addAll(paramCollection);
/*     */   } public boolean addAll(int paramInt, Collection<? extends Element> paramCollection) {
/* 532 */     return this.contents.addAll(paramInt, paramCollection);
/*     */   } public boolean removeAll(Collection<?> paramCollection) {
/* 534 */     return this.contents.removeAll(paramCollection);
/*     */   } public boolean retainAll(Collection<?> paramCollection) {
/* 536 */     return this.contents.retainAll(paramCollection);
/*     */   } public void clear() {
/* 538 */     this.contents.clear();
/*     */   } public boolean equals(Object paramObject) {
/* 540 */     return this.contents.equals(paramObject);
/*     */   } public int hashCode() {
/* 542 */     return this.contents.hashCode();
/*     */   } public Element get(int paramInt) {
/* 544 */     return this.contents.get(paramInt);
/*     */   } public Element set(int paramInt, Element paramElement) {
/* 546 */     return this.contents.set(paramInt, paramElement);
/*     */   } public void add(int paramInt, Element paramElement) {
/* 548 */     this.contents.add(paramInt, paramElement);
/*     */   } public Element remove(int paramInt) {
/* 550 */     return this.contents.remove(paramInt);
/*     */   } public int indexOf(Object paramObject) {
/* 552 */     return this.contents.indexOf(paramObject);
/*     */   } public int lastIndexOf(Object paramObject) {
/* 554 */     return this.contents.lastIndexOf(paramObject);
/*     */   } public ListIterator<Element> listIterator() {
/* 556 */     return this.contents.listIterator();
/*     */   } public ListIterator<Element> listIterator(int paramInt) {
/* 558 */     return this.contents.listIterator(paramInt);
/*     */   } public List<Element> subList(int paramInt1, int paramInt2) {
/* 560 */     return this.contents.subList(paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\select\Elements.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */