package io.github.zonnedev.ocpp;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Actions;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Actions;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SchemaCompletenessTest {
  @Test
  @DisplayName("Action inventories are complete and bijective")
  void it_exposes_complete_and_bijective_action_inventories() {
    assertThat(Ocpp16Action.values()).hasSize(39);
    assertThat(Ocpp201Action.values()).hasSize(64);
    assertThat(
      Arrays.stream(Ocpp16Action.values())
        .map(Ocpp16Action::wireName)
    ).doesNotHaveDuplicates();
    assertThat(
      Arrays.stream(Ocpp201Action.values())
        .map(Ocpp201Action::wireName)
    ).doesNotHaveDuplicates();
    for (Ocpp16Action action : Ocpp16Action.values()) {
      assertThat(
        action.requestType()
          .isRecord()
      ).isTrue();
      assertThat(
        action.responseType()
          .isRecord()
      ).isTrue();
      assertThat(
        Ocpp16Actions.definitionFor(action)
          .requestType()
      ).isEqualTo(action.requestType());
      assertThat(
        Ocpp16Actions.definitionFor(action)
          .responseType()
      ).isEqualTo(action.responseType());
    }
    for (Ocpp201Action action : Ocpp201Action.values()) {
      assertThat(
        action.requestType()
          .isRecord()
      ).isTrue();
      assertThat(
        action.responseType()
          .isRecord()
      ).isTrue();
      assertThat(
        Ocpp201Actions.definitionFor(action)
          .requestType()
      ).isEqualTo(action.requestType());
      assertThat(
        Ocpp201Actions.definitionFor(action)
          .responseType()
      ).isEqualTo(action.responseType());
    }
  }

  @Test
  @DisplayName("Sealed payload families expose every action payload")
  void it_exposes_every_action_payload_through_sealed_families() {
    assertThat(Ocpp16Request.class.getPermittedSubclasses()).hasSize(39)
      .allMatch(Class::isRecord);
    assertThat(Ocpp16Response.class.getPermittedSubclasses()).hasSize(39)
      .allMatch(Class::isRecord);
    assertThat(Ocpp201Request.class.getPermittedSubclasses()).hasSize(64)
      .allMatch(Class::isRecord);
    assertThat(Ocpp201Response.class.getPermittedSubclasses()).hasSize(64)
      .allMatch(Class::isRecord);
    assertThat(Ocpp16Request.class.isSealed()).isTrue();
  }
}
