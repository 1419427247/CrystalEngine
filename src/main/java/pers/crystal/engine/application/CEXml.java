package pers.crystal.engine.application;

import java.io.*;
import java.lang.reflect.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class CEXml {
    private static DocumentBuilder documentBuilder;

    public CEPerfab convertToObject(Node node) {
        try {
            Element root = (Element) node;
            CEPerfab perfab = (CEPerfab) Class.forName(root.getNodeName()).getConstructor().newInstance();
            perfab.convertToObject(root);
            return perfab;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DOMException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CEPerfab convertToObject(InputStream input) {
        try {
            Document document = documentBuilder.parse(input);
            Element root = document.getDocumentElement();
            CEPerfab object = (CEPerfab) Class.forName(root.getNodeName()).getDeclaredConstructor().newInstance();
            object.convertToObject(root);
            return object;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Document convertToDocument(CEPerfab perfab) {
        Document document = documentBuilder.newDocument();
        Node root = document.createElement(perfab.getClass().getName());
        perfab.convertToNode(document, root);
        document.appendChild(root);
        return document;
    }

    public static Node convertToNode(Document document, CEPerfab perfab) {
        Element root = document.createElement(perfab.getClass().getName());
        perfab.convertToNode(document, root);
        document.appendChild(root);
        return root;
    }

    public static Node convertToNode(Document document, String name, Object object) {
        Element root = null;
        if (object == null) {
            root = document.createElement("null");
            root.setAttribute("name", name);
            root.setAttribute("value", null);
        } else {
            root = document.createElement(object.getClass().getName());
            root.setAttribute("name", name);
            root.setAttribute("value", object.toString());
        }
        document.appendChild(root);
        return root;
    }

    public static void write(Document document, File file) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.transform(new DOMSource(document), new StreamResult(writer));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

	public static void Create() {
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
	}
}