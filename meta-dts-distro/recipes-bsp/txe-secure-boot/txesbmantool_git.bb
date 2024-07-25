SUMMARY = "Utility for generating TXE Secure Boot manifests"
HOMEPAGE = "https://github.com/Dasharo/coreboot"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = " \
    file://${WORKDIR}/git/LICENSES/GPL-2.0-only.txt;md5=5430828348d2cf7d4b5e8395f774a68e \
"

DEPENDS += "wolfssl"

SRC_URI = " \
    git://github.com/Dasharo/coreboot.git;branch=txe_sb_tool;protocol=https \
"

SRCREV = "d6a30f4fd3a7fca9551eefa9730f5c0f09328043"

S = "${WORKDIR}/git/util/txesbmantool"

inherit pkgconfig

EXTRA_OEMAKE = ' \
                DESTDIR="${D}" \
                PREFIX="${prefix}" \
                '

do_configure:prepend(){
    export PKG_CONFIG_PATH="${STAGING_LIBDIR}/pkgconfig:${STAGING_DIR_HOST}/usr/lib/pkgconfig"
}

do_compile:prepend() {
    export PKG_CONFIG_PATH="${STAGING_LIBDIR}/pkgconfig:${STAGING_DIR_HOST}/usr/lib/pkgconfig"
}

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}

INSANE_SKIP:${PN} += "ldflags"

FILES:${PN} += " \
    ${bindir}/txesbmantool \
"
