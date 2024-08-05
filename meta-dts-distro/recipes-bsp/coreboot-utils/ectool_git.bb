require coreboot-utils.inc

SUMMARY = "Dumps the RAM of a laptop's Embedded/Environmental Controller (EC)."

PV = "1.0+git${SRCPV}"

EXTRA_OEMAKE = ' \
                DESTDIR="${D}" \
                PREFIX="${prefix}" \
                '

do_compile () {
  oe_runmake -C util/ectool
}

do_install () {
  oe_runmake -C util/ectool install
}
