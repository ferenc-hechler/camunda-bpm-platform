/* Licensed under the Apache License, Version 2.0 (the "License");
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
 */
package org.camunda.bpm.engine.rest.helper;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.camunda.bpm.engine.repository.DecisionDefinition;

public class MockDecisionDefinitionBuilder {

  private String id = null;
  private String key = null;
  private String category = null;
  private String name = null;
  private int version = 0;
  private String resource = null;
  protected String diagramResource = null;
  private String deploymentId = null;
  private String tenantId = null;

  public MockDecisionDefinitionBuilder id(String id) {
    this.id = id;
    return this;
  }

  public MockDecisionDefinitionBuilder key(String key) {
    this.key = key;
    return this;
  }

  public MockDecisionDefinitionBuilder category(String category) {
    this.category = category;
    return this;
  }

  public MockDecisionDefinitionBuilder name(String name) {
    this.name = name;
    return this;
  }

  public MockDecisionDefinitionBuilder version(int version) {
    this.version = version;
    return this;
  }

  public MockDecisionDefinitionBuilder resource(String resource) {
    this.resource = resource;
    return this;
  }

  public MockDecisionDefinitionBuilder diagram(String diagramResource) {
    this.diagramResource = diagramResource;
    return this;
  }

  public MockDecisionDefinitionBuilder deploymentId(String deploymentId) {
    this.deploymentId = deploymentId;
    return this;
  }

  public MockDecisionDefinitionBuilder tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  public DecisionDefinition build() {
    DecisionDefinition mockDefinition = mock(DecisionDefinition.class);

    when(mockDefinition.getId()).thenReturn(id);
    when(mockDefinition.getCategory()).thenReturn(category);
    when(mockDefinition.getName()).thenReturn(name);
    when(mockDefinition.getKey()).thenReturn(key);
    when(mockDefinition.getVersion()).thenReturn(version);
    when(mockDefinition.getResourceName()).thenReturn(resource);
    when(mockDefinition.getDiagramResourceName()).thenReturn(diagramResource);
    when(mockDefinition.getDeploymentId()).thenReturn(deploymentId);
    when(mockDefinition.getTenantId()).thenReturn(tenantId);

    return mockDefinition;
  }

}
