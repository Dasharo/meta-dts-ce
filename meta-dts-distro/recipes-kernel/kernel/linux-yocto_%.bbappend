FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://dts.cfg \
    file://enable-memconsole-coreboot.cfg \
    file://intel-mei.cfg \
    file://intel-other.cfg \
    file://intel-sound.cfg \
    file://silence-terminal-logs.cfg \
    file://touchpad.cfg \
    file://tpm.cfg \
"
