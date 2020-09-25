/*-
 * ---license-start
 * keycloak-config-cli
 * ---
 * Copyright (C) 2017 - 2020 adorsys GmbH & Co. KG @ https://adorsys.com
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

package de.adorsys.keycloak.config.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionUtilTest {
    @Test
    void shouldThrowOnNew() {
        assertThrows(IllegalStateException.class, VersionUtil::new);
    }

    @Test
    void gt() {
        assertTrue(VersionUtil.gt("10.1", "11.0"));
        assertFalse(VersionUtil.gt("10.1", "10.1"));
        assertFalse(VersionUtil.gt("10.1", "9.2"));
    }

    @Test
    void ge() {
        assertTrue(VersionUtil.ge("10.1", "11.0"));
        assertTrue(VersionUtil.ge("10.1", "10.1"));
        assertFalse(VersionUtil.ge("10.1", "9.2"));
    }

    @Test
    void lt() {
        assertFalse(VersionUtil.lt("10.1", "11.0"));
        assertFalse(VersionUtil.lt("10.1", "10.1"));
        assertTrue(VersionUtil.lt("10.1", "9.2"));
    }

    @Test
    void le() {
        assertFalse(VersionUtil.le("10.1", "11.0"));
        assertTrue(VersionUtil.le("10.1", "10.1"));
        assertTrue(VersionUtil.le("10.1", "9.2"));
    }

    @Test
    void eq() {
        assertFalse(VersionUtil.eq("10.1", "11.0"));
        assertTrue(VersionUtil.eq("10.1", "10.1"));
        assertFalse(VersionUtil.eq("10.1", "9.2"));
    }

    @Test
    void eqPrefix() {
        assertTrue(VersionUtil.eqPrefix("10.1", "10.1"));
        assertFalse(VersionUtil.eqPrefix("10.1", "9.2"));
    }
}
