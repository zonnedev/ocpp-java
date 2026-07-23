module io.github.zonnedev.ocpp {
  requires transitive org.jspecify;
  requires transitive com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.datatype.jsr310;

  exports io.github.zonnedev.ocpp.api;
  exports io.github.zonnedev.ocpp.api.datatransfer;
  exports io.github.zonnedev.ocpp.codec;
  exports io.github.zonnedev.ocpp.extension.v16.iso15118;
  exports io.github.zonnedev.ocpp.jackson;
  exports io.github.zonnedev.ocpp.v16;
  exports io.github.zonnedev.ocpp.v16.model;
  exports io.github.zonnedev.ocpp.v16.model.type;
  exports io.github.zonnedev.ocpp.v201;
  exports io.github.zonnedev.ocpp.v201.model;
  exports io.github.zonnedev.ocpp.v201.model.type;
}
