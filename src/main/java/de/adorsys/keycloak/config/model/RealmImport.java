/*-
 * ---license-start
 * keycloak-config-cli
 * ---
 * Copyright (C) 2017 - 2021 adorsys GmbH & Co. KG @ https://adorsys.com
 * ---
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ---license-end
 */

package de.adorsys.keycloak.config.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.keycloak.representations.idm.AuthenticationFlowRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RealmImport extends RealmRepresentation {
    private List<AuthenticationFlowImport> authenticationFlowImports;

    private String checksum;

    @Override
    @SuppressWarnings("java:S1168")
    public List<AuthenticationFlowRepresentation> getAuthenticationFlows() {
        if (authenticationFlowImports == null) return null;

        return new ArrayList<>(authenticationFlowImports);
    }

    @SuppressWarnings("unused")
    @JsonSetter("authenticationFlows")
    public void setAuthenticationFlowImports(List<AuthenticationFlowImport> authenticationFlowImports) {
        this.authenticationFlowImports = authenticationFlowImports;
    }

    @JsonIgnore
    public String getChecksum() {
        return checksum;
    }

    @JsonIgnore
    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
