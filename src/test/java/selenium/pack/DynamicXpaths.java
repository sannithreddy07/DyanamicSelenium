package selenium.pack;

public class DynamicXpaths {
	
	/*
	 * Use custom xpaths
	 * Use xpath axes to locate webelement
	 * use contains, text(),
	 * ancestor: These axes indicate all the ancestors relative to the context node, also reaching up to the root node.
ancestor-or-self: This one indicates the context node and all the ancestors relative to the context node, and includes the root node.
attribute: This indicates the attributes of the context node. It can be represented with the “@” symbol.
child: This indicates the children of the context node.
descendent: This indicates the children, grandchildren, and their children (if any) of the context node. This does NOT indicate the Attribute and Namespace.
descendent-or-self: This indicates the context node and the children, and grandchildren and their children (if any) of the context node. This does NOT indicate the attribute and namespace.
following: This indicates all the nodes that appear after the context node in the HTML DOM structure. This does NOT indicate descendent, attribute, and namespace.
following-sibling: This one indicates all the sibling nodes (same parent as the context node) that appear after the context node in the HTML DOM structure. This does NOT indicate descendent, attribute, and namespace.
namespace: This indicates all the namespace nodes of the context node.
parent: This indicates the parent of the context node.
preceding: This indicates all the nodes that appear before the context node in the HTML DOM structure. This does NOT indicate descendent, attribute, and namespace.
preceding-sibling: This one indicates all the sibling nodes (same parent as context node) that appear before the context node in the HTML DOM structure. This does NOT indicate descendent, attribute, and namespace.
self: This one indicates the context node. 
	 */
//	#1) Ancestor
//	Agenda: To identify the ancestor element from the context node.
//
//	XPath#1: //div[@class=’Mammal’]/ancestor::div
//		
//		XPath#2: //div[@class='Mammal']/ancestor::div[@class='Animal']
//			#2) Ancestor-or-self 
//			
//			Agenda: To identify the context node and the ancestor element from the context node.
//
//			XPath#1: //div[@class=’Mammal’]/ancestor-or-self::div
//				#3) Child
//
//			Agenda: To identify the child of context node “Mammal”.
//
//			XPath#1: //div[@class=’Mammal’]/child::div
//				
//				#4) Descendent
//
//			Agenda: To identify the children and grandchildren of the context node (for instance: ‘Animal’).
//
//			XPath#1: //div[@class=’Animal’]/descendant::div
//				
//				#5) Descendant-or-self
//
//			Agenda: To find the element itself, and its descendants.
//
//			XPath1: //div[@class=’Animal’]/descendant-or-self::div
//				
//				#6) Following
//
//			Agenda: To find all the nodes that follow the context node. Here, the context node is the div that contains the Mammal element.
//
//			XPath: //div[@class=’Mammal’]/following::div
//				
//				#7) Following-sibling
//
//			Agenda: To find all the nodes after the context node that share the same parent, and are a sibling to the context node.
//
//			XPath: //div[@class=’Mammal’]/following-sibling::div

	//	#8) Preceeding
//
//Agenda: To find all the nodes that follow the context node. Here, the context node is the div that contains the Mammal element.
//
//XPath: //div[@class=’Mammal’]/Preceeding::div
//	
//	#9) Preceeding-sibling
//
//Agenda: To find all the nodes after the context node that share the same parent, and are a sibling to the context node.
//
//XPath: //div[@class=’Mammal’]/Preceeding-sibling::div
	
//	#10) Parent
//
//	Agenda: To find the parent element of the context node. If the context node itself is an ancestor, it won’t have a parent node and would fetch no matching nodes.
//
//	Context Node#1: Mammal
//
//	XPath: //div[@class=’Mammal’]/parent::div
	

	

}
