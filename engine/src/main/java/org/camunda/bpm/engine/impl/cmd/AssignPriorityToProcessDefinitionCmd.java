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
package org.camunda.bpm.engine.impl.cmd;

import org.camunda.bpm.engine.impl.interceptor.Command;
import org.camunda.bpm.engine.impl.interceptor.CommandContext;
import org.camunda.bpm.engine.impl.persistence.entity.ProcessDefinitionEntity;

public class AssignPriorityToProcessDefinitionCmd implements Command<Void> {

  protected String processDefinitionId;
  protected int priority;

  public AssignPriorityToProcessDefinitionCmd(String processDefinitionId, int priority) {
    this.processDefinitionId = processDefinitionId;
    this.priority = priority;
  }

  @Override
  public Void execute(CommandContext commandContext) {
    ProcessDefinitionEntity processDefinition =
        commandContext
          .getProcessDefinitionManager()
          .findLatestProcessDefinitionById(processDefinitionId);

    processDefinition.setJobPriority(priority);

    return null;
  }

}
