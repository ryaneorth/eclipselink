/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
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
// Denise Smith - October 2011
package org.eclipse.persistence.testing.jaxb.xmlbindings;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class XMLBindingsWithExternalMetadataTestCases extends XMLBindingsTestCases{

    public XMLBindingsWithExternalMetadataTestCases(String name) throws Exception {
        super(name);
    }

    @Override
    protected Map getProperties() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("org/eclipse/persistence/testing/jaxb/xmlbindings/bindings-oxm.xml");

        HashMap<String, Source> metadataSourceMap = new HashMap<String, Source>();
        metadataSourceMap.put("org.eclipse.persistence.jaxb.xmlmodel", new StreamSource(inputStream));
        Map<String, Map<String, Source>> properties = new HashMap<String, Map<String, Source>>();
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, metadataSourceMap);


        return properties;
    }

}
