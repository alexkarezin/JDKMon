/*
 * Copyright (c) 2021 by Gerrit Grunwald
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.hansolo.fx.jdkmon.tools;

import eu.hansolo.jdktools.scopes.BuildScope;
import eu.hansolo.jdktools.versioning.VersionNumber;
import io.foojay.api.discoclient.pkg.Feature;


public class Distro {
    private final String        name;
    private final String        apiString;
    private final String        version;
    private final VersionNumber versionNumber;
    private final String        jdkMajorVersion;
    private final String        operatingSystem;
    private final String        architecture;
    private final Boolean       fxBundled;
    private final String        location;
    private final Feature       feature;
    private final BuildScope    buildScope;
    private final boolean       handledBySdkman;
    private final String        path;
    private       boolean       inUse;


    public Distro(final String name, final String apiString, final String version, final String jdkMajorVersion, final String operatingSystem, final String architecture, final Boolean fxBundled, final String location, final Feature feature, final BuildScope buildScope, final boolean handledBySdkman, final String path) {
        this.name            = name;
        this.apiString       = apiString;
        this.version         = version;
        this.versionNumber   = VersionNumber.fromText(version);
        this.jdkMajorVersion = jdkMajorVersion;
        this.operatingSystem = operatingSystem;
        this.architecture    = architecture;
        this.fxBundled       = fxBundled;
        this.location        = location;
        this.feature         = feature;
        this.buildScope      = buildScope;
        this.handledBySdkman = handledBySdkman;
        this.path            = path;
        this.inUse           = false;
    }


    public String getName() { return name; }

    public String getApiString() { return apiString; }

    public String getVersion() { return version; }

    public String getJdkMajorVersion() { return jdkMajorVersion; }

    public String getOperatingSystem() { return operatingSystem; }

    public String getArchitecture() { return architecture; }

    public Boolean getFxBundled() { return fxBundled; }

    public String getLocation() { return location; }

    public Feature getFeature() { return feature; }

    public BuildScope getBuildScope() { return buildScope; }

    public VersionNumber getVersionNumber() { return versionNumber; }

    public boolean isHandledBySdkman() { return handledBySdkman; }

    public String getPath() { return path; }

    public boolean isInUse() { return inUse; }
    public void setInUse(final boolean inUse) { this.inUse = inUse; }

    @Override public String toString() {
        return new StringBuilder().append("{")
                                  .append("\"name\":\"").append(getName()).append("\",")
                                  .append("\"api_string\":\"").append(getApiString()).append("\",")
                                  .append("\"version\":\"").append(getVersion()).append("\",")
                                  .append("\"operating_system\":\"").append(getOperatingSystem()).append("\",")
                                  .append("\"architecture\":\"").append(getArchitecture()).append("\",")
                                  .append("\"fx\":\"").append(getFxBundled()).append("\",")
                                  .append("\"location\":\"").append(getLocation()).append("\",")
                                  .append("\"feature\":\"").append(getFeature()).append("\",")
                                  .append("\"handled_by_sdkman\":").append(isHandledBySdkman()).append(",")
                                  .append("\"path\":\"").append(path).append("\",")
                                  .append("\"in_use\":").append(isInUse())
                                  .append("}")
                                  .toString();
    }

    @Override public boolean equals(final Object obj) {
        if (!(obj instanceof Distro)) { return false; }
        Distro distribution = (Distro) obj;
        return (distribution.getApiString().equals(distribution.getApiString()) &&
                distribution.getVersion().equals(getVersion()) &&
                distribution.getFxBundled() == fxBundled);
    }

    @Override public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (null == name    ? 0 : name.hashCode());
        hash = 31 * hash + (null == version ? 0 : version.hashCode());
        return hash;
    }
}
