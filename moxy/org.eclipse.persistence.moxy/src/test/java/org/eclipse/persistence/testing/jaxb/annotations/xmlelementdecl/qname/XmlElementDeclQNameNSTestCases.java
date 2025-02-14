/*
 * Copyright (c) 2011, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Denise Smith - May 2013
package org.eclipse.persistence.testing.jaxb.annotations.xmlelementdecl.qname;

import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import org.eclipse.persistence.internal.oxm.Constants;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.XMLConstants;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class XmlElementDeclQNameNSTestCases extends JAXBWithJSONTestCases{
     private static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/annotations/xmlelementdecl/qname.xml";
     private static String XML_WRITE_RESOURCE = "org/eclipse/persistence/testing/jaxb/annotations/xmlelementdecl/qname_write.xml";
     private static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/annotations/xmlelementdecl/qname.json";
     private static String JSON_WRITE_RESOURCE = "org/eclipse/persistence/testing/jaxb/annotations/xmlelementdecl/qname_write.json";

    public XmlElementDeclQNameNSTestCases(String name) throws Exception {
        super(name);
         setControlDocument(XML_RESOURCE);
         setControlJSON(JSON_RESOURCE);
         setWriteControlDocument(XML_WRITE_RESOURCE);
         setWriteControlJSON(JSON_WRITE_RESOURCE);
         setClasses(new Class<?>[] {ObjectFactory.class});

         Map<String, String> namespaces = new HashMap<String, String>();
         namespaces.put(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI, "xsd");
         jaxbMarshaller.setProperty(MarshallerProperties.NAMESPACE_PREFIX_MAPPER, namespaces);
         jaxbUnmarshaller.setProperty(MarshallerProperties.NAMESPACE_PREFIX_MAPPER, namespaces);
    }

    @Override
    protected Object getControlObject() {
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<QName> jbe=objectFactory.createTheTest(Constants.STRING_QNAME);
        return jbe;
    }

}
