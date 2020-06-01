/*
 * NYASA ADMIN TEMPLATE JAVASCRIPT
 * ======================================================================
 * NOTE : All JavaScript plugins require jQuery to be included
 * http://jquery.com/
 *
 */
$(document).ready(function() {
        "use strict";
        window.nyasa = {
                container: $("#container"),
                contentContainer: $("#content-container"),
                navbar: $("#navbar"),
                mainNav: $("#mainnav-container"),
                aside: $("#aside-container"),
                footer: $("#footer"),
                scrollTop: $("#scroll-top"),
                window: $(window),
                body: $("body"),
                bodyHtml: $("body, html"),
                document: $(document),
                screenSize: "",
                isMobile: function() {
                    return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)
                }(),
                randomInt: function(a, b) {
                    return Math.floor(Math.random() * (b - a + 1) + a)
                },
                transition: function() {
                    var a = document.body || document.documentElement,
                        b = a.style,
                        c = void 0 !== b.transition || void 0 !== b.WebkitTransition;
                    return c
                }()
            },

            nyasa.window.on("load", function() {
                //Activate the Bootstrap tooltips		
                var a = $(".add-tooltip");
                a.length && a.tooltip();

                var b = $(".add-popover");
                b.length && b.popover();

                // STYLEABLE SCROLLBARS
                // =================================================================
                // Require nanoScroller
                // http://jamesflorentino.github.io/nanoScrollerJS/
                // =================================================================

                var c = $(".nano");
                c.length && c.nanoScroller({
                        preventPageScrolling: !0
                    }),

                    // Update nancoscroller		
                    $("#navbar-container .navbar-top-links").on("shown.bs.dropdown", ".dropdown", function() {
                        $(this).find(".nano").nanoScroller({
                            preventPageScrolling: !0
                        })
                    }),

                    nyasa.body.addClass("page-effect")

                /* ========================================================================
                 * PANEL REMOVAL v1.0
                 * -------------------------------------------------------------------------
                 * Optional Font Icon : By Font Awesome
                 * http://fortawesome.github.io/Font-Awesome/
                 * ========================================================================*/

                var a = $('[data-dismiss="panel"]');
                a.length && a.one("click", function(a) {
                    a.preventDefault();
                    var b = $(this).parents(".panel");
                    b.addClass("remove").on("transitionend webkitTransitionEnd oTransitionEnd MSTransitionEnd", function(a) {
                        "opacity" == a.originalEvent.propertyName && b.remove()
                    })
                })

                /* ========================================================================
                 * SCROLL TO TOP BUTTON v1.0
                 * -------------------------------------------------------------------------
                 * Optional Font Icon : By Font Awesome
                 * http://fortawesome.github.io/Font-Awesome/
                 * ========================================================================*/

                if (nyasa.scrollTop.length && !nyasa.isMobile) {
                    var a = !0,
                        b = 250;

                    nyasa.window.scroll(function() {
                            nyasa.window.scrollTop() > b && !a ? (nyasa.navbar.addClass("shadow"), nyasa.scrollTop.addClass("in"), a = !0) : nyasa.window.scrollTop() < b && a && (nyasa.navbar.removeClass("shadow"), nyasa.scrollTop.removeClass("in"), a = !1)
                        }),

                        nyasa.scrollTop.on("click", function(a) {
                            a.preventDefault(), nyasa.bodyHtml.animate({
                                scrollTop: 0
                            }, 500)
                        })
                }


                // NAVIGATION SHORTCUT BUTTONS
                // =================================================================
                // Require Bootstrap Popover
                // http://getbootstrap.com/javascript/#popovers
                // =================================================================


                var a = $("#mainnav-shortcut");
                a.length && a.find("li").each(function() {
                    var a = $(this);
                    a.popover({
                        animation: !1,
                        trigger: "hover focus",
                        placement: "bottom",
                        container: "#mainnav-container",
                        template: '<div class="popover mainnav-shortcut"><div class="arrow"></div><div class="popover-content"></div>'
                    })
                })


                // STYLEABLE SCROLLBARS
                // =================================================================
                // Require nanoScroller
                // http://jamesflorentino.github.io/nanoScrollerJS/
                // =================================================================


                if (nyasa.aside.length) {

                    nyasa.aside.find(".nano").nanoScroller({
                        preventPageScrolling: !0,
                        alwaysVisible: !1
                    });

                    var a = $(".aside-toggle");
                    a.length && a.on("click", function(a) {
                        $.jasmineAside("toggleHideShow")
                    })
                }

                nyasa.mainNav.length && nyasa.mainNav.jasmineAffix({
                    className: "mainnav-fixed"
                }), nyasa.aside.length && nyasa.aside.jasmineAffix({
                    className: "aside-fixed"
                })

            })


        /* ========================================================================
         * nyasa CHECK v1.1
         * -------------------------------------------------------------------------
         * - squaredesigns.net -
         * ========================================================================*/


        var i, j = function(a) {
                if (!a.data("nyasa-check")) {
                    a.data("nyasa-check", !0), a.text().trim().length ? a.addClass("form-text") : a.removeClass("form-text");
                    var b = a.find("input")[0],
                        c = b.name,
                        d = function() {
                            return !("radio" != b.type || !c) && $(".form-radio").not(a).find("input").filter("input[name=" + c + "]").parent()
                        }(),
                        e = function() {
                            "radio" == b.type && d.length && d.each(function() {
                                var a = $(this);
                                a.hasClass("active") && a.trigger("nyasa.ch.unchecked"), a.removeClass("active")
                            }), b.checked ? a.addClass("active").trigger("nyasa.ch.checked") : a.removeClass("active").trigger("nyasa.ch.unchecked")
                        };
                    b.checked ? a.addClass("active") : a.removeClass("active"), $(b).on("change", e)
                }
            },

            c = {
                isChecked: function() {
                    return this[0].checked
                },
                toggle: function() {
                    return this[0].checked = !this[0].checked, this.trigger("change"), null
                },
                toggleOn: function() {
                    return this[0].checked || (this[0].checked = !0, this.trigger("change")), null
                },
                toggleOff: function() {
                    return this[0].checked && "checkbox" == this[0].type && (this[0].checked = !1, this.trigger("change")), null
                }
            };


        $.fn.jasmineCheck = function(a) {
                var b = !1;
                return this.each(function() {
                    c[a] ? b = c[a].apply($(this).find("input"), Array.prototype.slice.call(arguments, 1)) : "object" != typeof a && a || j($(this))
                }), b
            },

            i = $(".form-checkbox, .form-radio"), i.length && i.jasmineCheck()

        nyasa.document.on("change", ".btn-file :file", function() {
            var a = $(this),
                b = a.get(0).files ? a.get(0).files.length : 1,
                c = a.val().replace(/\\/g, "/").replace(/.*\//, ""),
                d = function() {
                    try {
                        return a[0].files[0].size
                    } catch (a) {
                        return "Nan"
                    }
                }(),
                e = function() {
                    if ("Nan" == d) return "Unknown";
                    var a = Math.floor(Math.log(d) / Math.log(1024));
                    return 1 * (d / Math.pow(1024, a)).toFixed(2) + " " + ["B", "kB", "MB", "GB", "TB"][a]
                }();
            a.trigger("fileselect", [b, c, e])
        })


        /* ========================================================================
         * NAVIGATION v1.2.1
         * -------------------------------------------------------------------------
         *
         * Require Bootstrap Popover
         * http://getbootstrap.com/javascript/#popovers
         *
         * Require jQuery Resize End
         * https://github.com/nielse63/jQuery-ResizeEnd
         *
         * ========================================================================*/

        var k = $('#mainnav-menu > li > a, #mainnav-menu-wrap .mainnav-widget a[data-toggle="menu-widget"]'),
            l = $("#mainnav").height(),
            m = null,
            n = false,
            o = false,
            p = null,

            // Determine and bind hover or "touch" event
            // ===============================================

            r = function() {
                var a;
                k.each(function() {
                    var b = $(this),
                        c = b.children(".menu-title"),
                        d = b.siblings(".collapse"),
                        e = $(b.attr("data-target")),
                        f = e.length ? e.parent() : null,
                        g = null,
                        h = null,
                        i = null,
                        j = null,
                        p = (b.outerHeight() - b.height() / 4, function() {
                            return e.length && b.on("click", function(a) {
                                a.preventDefault()
                            }), !!d.length && (b.on("click", function(a) {
                                a.preventDefault()
                            }).parent("li").removeClass("active"), !0)
                        }()),
                        q = null,
                        r = function(a) {
                            clearInterval(q), q = setInterval(function() {
                                a.nanoScroller({
                                    preventPageScrolling: !0,
                                    alwaysVisible: !0
                                }), clearInterval(q)
                            }, 700)
                        };


                    $(document).click(function(a) {
                            $(a.target).closest("#mainnav-container").length || b.removeClass("hover").popover("hide")
                        }),

                        $("#mainnav-menu-wrap > .nano").on("update", function(a, c) {
                            b.removeClass("hover").popover("hide")
                        }),

                        b.popover({
                            animation: false,
                            trigger: "manual",
                            container: "#mainnav",
                            viewport: b,
                            html: true,
                            title: function() {
                                return p ? c.html() : null
                            },
                            content: function() {
                                var a;
                                return p ? (a = $('<div class="sub-menu"></div>'), d.addClass("pop-in").wrap('<div class="nano-content"></div>').parent().appendTo(a)) : e.length ? (a = $('<div class="sidebar-widget-popover"></div>'), e.wrap('<div class="nano-content"></div>').parent().appendTo(a)) : a = '<span class="single-content">' + c.html() + "</span>", a
                            },
                            template: '<div class="popover menu-popover"><h4 class="popover-title"></h4><div class="popover-content"></div></div>'
                        }).on("show.bs.popover", function() {
                            if (!g) {
                                if (g = b.data("bs.popover").tip(), h = g.find(".popover-title"), i = g.children(".popover-content"), !p && 0 == e.length) return;
                                j = i.children(".sub-menu")
                            }!p && 0 == e.length
                        }).on("shown.bs.popover", function() {
                            if (!p && 0 == e.length) {
                                var a = 0 - .5 * b.outerHeight();
                                return void i.css({
                                    "margin-top": a + "px",
                                    width: "auto"
                                })
                            }

                            var c = parseInt(g.css("top")),
                                d = b.outerHeight(),
                                f = function() {
                                    return nyasa.container.hasClass("mainnav-fixed") ? $(window).outerHeight() - c - d : $(document).height() - c - d
                                }(),
                                j = i.find(".nano-content").children().css("height", "auto").outerHeight();
                            i.find(".nano-content").children().css("height", ""), c > f ? (h.length && !h.is(":visible") && (d = Math.round(0 - .5 * d)), c -= 5, i.css({
                                    top: "",
                                    bottom: d + "px",
                                    height: c
                                })

                                .children().addClass("nano").css({
                                    width: "100%"
                                })

                                .nanoScroller({
                                    preventPageScrolling: true
                                }),

                                r(i.find(".nano"))) : (!nyasa.container.hasClass("navbar-fixed") && nyasa.mainNav.hasClass("affix-top") && (f -= 50), j > f ? ((nyasa.container.hasClass("navbar-fixed") || nyasa.mainNav.hasClass("affix-top")) && (f -= d + 5), f -= 5, i.css({
                                    top: d + "px",
                                    bottom: "",
                                    height: f
                                })

                                .children().addClass("nano").css({
                                    width: "100%"
                                })

                                .nanoScroller({
                                    preventPageScrolling: true
                                }), r(i.find(".nano"))) : (h.length && !h.is(":visible") && (d = Math.round(0 - .5 * d)), i.css({
                                top: d + "px",
                                bottom: "",
                                height: "auto"
                            }))), h.length && h.css("height", b.outerHeight()), i.on("click", function() {
                                i.find(".nano-pane").hide(), r(i.find(".nano"))
                            })
                        }).on("hidden.bs.popover", function() {
                            b.removeClass("hover"), p ? d.removeAttr("style").appendTo(b.parent()) : e.length && e.appendTo(f), clearInterval(a)
                        }).on("click", function() {
                            nyasa.container.hasClass("mainnav-sm") && (k.popover("hide"), b.addClass("hover").popover("show"))
                        }).hover(function() {
                            k.popover("hide"), b.addClass("hover").popover("show")
                        }, function() {
                            clearInterval(a), a = setInterval(function() {
                                g && (g.one("mouseleave", function() {
                                    b.removeClass("hover").popover("hide")
                                }), g.is(":hover") || b.removeClass("hover").popover("hide")), clearInterval(a)
                            }, 500)
                        })
                }), o = !0
            },
            s = function() {
                var a = $("#mainnav-menu").find(".collapse");
                a.length && a.each(function() {
                    var a = $(this);
                    a.hasClass("in") ? a.parent("li").addClass("active") : a.parent("li").removeClass("active")
                }), null != m && m.length && m.nanoScroller({
                    stop: !0
                }), k.popover("destroy").unbind("mouseenter mouseleave"), o = !1
            },
            t = function() {
                var b, a = nyasa.container.width();
                b = a <= 740 ? "xs" : a > 740 && a < 992 ? "sm" : a >= 992 && a <= 1200 ? "md" : "lg", p != b && (p = b, nyasa.screenSize = b, "sm" == nyasa.screenSize && nyasa.container.hasClass("mainnav-lg") && $.nyasaNav("collapse"))
            },
            u = function(a) {
                return nyasa.mainNav.jasmineAffix("update"), s(), t(), ("collapse" == n || nyasa.container.hasClass("mainnav-sm")) && (nyasa.container.removeClass("mainnav-in mainnav-out mainnav-lg"), r()), l = $("#mainnav").height(), n = !1, null
            },
            c = {
                revealToggle: function() {
                    nyasa.container.hasClass("reveal") || nyasa.container.addClass("reveal"), nyasa.container.toggleClass("mainnav-in mainnav-out").removeClass("mainnav-lg mainnav-sm"), o && s()
                },
                revealIn: function() {
                    nyasa.container.hasClass("reveal") || nyasa.container.addClass("reveal"), nyasa.container.addClass("mainnav-in").removeClass("mainnav-out mainnav-lg mainnav-sm"), o && s()
                },
                revealOut: function() {
                    nyasa.container.hasClass("reveal") || nyasa.container.addClass("reveal"), nyasa.container.removeClass("mainnav-in mainnav-lg mainnav-sm").addClass("mainnav-out"), o && s()
                },
                slideToggle: function() {
                    nyasa.container.hasClass("slide") || nyasa.container.addClass("slide"), nyasa.container.toggleClass("mainnav-in mainnav-out").removeClass("mainnav-lg mainnav-sm"), o && s()
                },
                slideIn: function() {
                    nyasa.container.hasClass("slide") || nyasa.container.addClass("slide"), nyasa.container.addClass("mainnav-in").removeClass("mainnav-out mainnav-lg mainnav-sm"), o && s()
                },
                slideOut: function() {
                    nyasa.container.hasClass("slide") || nyasa.container.addClass("slide"), nyasa.container.removeClass("mainnav-in mainnav-lg mainnav-sm").addClass("mainnav-out"), o && s()
                },
                


                pushToggle: function() {
                    nyasa.container.toggleClass("mainnav-in mainnav-out").removeClass("mainnav-lg mainnav-sm"), nyasa.container.hasClass("mainnav-in mainnav-out") && nyasa.container.removeClass("mainnav-in"), o && s()
                },
                pushIn: function() {
                    nyasa.container.addClass("mainnav-in").removeClass("mainnav-out mainnav-lg mainnav-sm"), o && s()
                },
                pushOut: function() {
                    nyasa.container.removeClass("mainnav-in mainnav-lg mainnav-sm").addClass("mainnav-out"), o && s()
                },
                colExpToggle: function() {
                    return nyasa.container.hasClass("mainnav-lg mainnav-sm") && nyasa.container.removeClass("mainnav-lg"), nyasa.container.toggleClass("mainnav-lg mainnav-sm").removeClass("mainnav-in mainnav-out"), nyasa.window.trigger("resize")
                },
                collapse: function() {
                    return nyasa.container.addClass("mainnav-sm").removeClass("mainnav-lg mainnav-in mainnav-out"), n = "collapse", nyasa.window.trigger("resize")
                },
                expand: function() {
                    return nyasa.container.removeClass("mainnav-sm mainnav-in mainnav-out").addClass("mainnav-lg"), nyasa.window.trigger("resize")
                },



                togglePosition: function() {
                    nyasa.container.toggleClass("mainnav-fixed"), nyasa.mainNav.jasmineAffix("update")
                },
                fixedPosition: function() {
                    nyasa.container.addClass("mainnav-fixed"), nyasa.mainNav.jasmineAffix("update")
                },
                staticPosition: function() {
                    nyasa.container.removeClass("mainnav-fixed"), nyasa.mainNav.jasmineAffix("update")
                },
                update: u,
                forceUpdate: t,
                getScreenSize: function() {
                    return p
                }
            };

        $.nyasaNav = function(a, b) {
                if (c[a]) {
                    "colExpToggle" != a && "expand" != a && "collapse" != a || ("xs" == nyasa.screenSize && "collapse" == a ? a = "pushOut" : "xs" != nyasa.screenSize && "sm" != nyasa.screenSize || "colExpToggle" != a && "expand" != a || !nyasa.container.hasClass("mainnav-sm") || (a = "pushIn"));
                    var d = c[a].apply(this, Array.prototype.slice.call(arguments, 1));
                    if (b) return b();
                    if (d) return d
                }
                return null
            },

            $.fn.isOnScreen = function() {
                var a = {
                    top: nyasa.window.scrollTop(),
                    left: nyasa.window.scrollLeft()
                };
                a.right = a.left + nyasa.window.width(), a.bottom = a.top + nyasa.window.height();
                var b = this.offset();
                return b.right = b.left + this.outerWidth(), b.bottom = b.top + this.outerHeight(), !(a.right < b.left || a.left > b.right || a.bottom < b.bottom || a.top > b.top)
            },

            nyasa.window.on("resizeEnd", u).trigger("resize"), nyasa.window.on("load", function() {

                var a = $(".mainnav-toggle");
                a.length && a.on("click", function(b) {
                    b.preventDefault(), a.hasClass("push") ? $.nyasaNav("pushToggle") : a.hasClass("slide") ? $.nyasaNav("slideToggle") : a.hasClass("reveal") ? $.nyasaNav("revealToggle") : $.nyasaNav("colExpToggle")
                });


                // COLLAPSIBLE MENU LIST
                // =================================================================
                // Require MetisMenu
                // http://demo.onokumus.com/metisMenu/
                // =================================================================

                var b = $("#mainnav-menu");
                b.length && ($("#mainnav-menu").metisMenu({
                        toggle: true
                    }),

                    // STYLEABLE SCROLLBARS
                    // =================================================================
                    // Require nanoScroller
                    // http://jamesflorentino.github.io/nanoScrollerJS/
                    // =================================================================

                    m = nyasa.mainNav.find(".nano"), m.length && m.nanoScroller({
                        preventPageScrolling: true
                    }))
            });

        /* ========================================================================
         * nyasa ASIDE v1.0.1
         * -------------------------------------------------------------------------
         * - squaredesigns.net -
         * ========================================================================*/

        var w = {
                toggleHideShow: function() {
                    nyasa.container.toggleClass("aside-in"), nyasa.window.trigger("resize"), nyasa.container.hasClass("aside-in") && x()
                },
                show: function() {
                    nyasa.container.addClass("aside-in"), nyasa.window.trigger("resize"), x()
                },
                hide: function() {
                    nyasa.container.removeClass("aside-in"), nyasa.window.trigger("resize")
                },
                toggleAlign: function() {
                    nyasa.container.toggleClass("aside-left"), nyasa.aside.jasmineAffix("update")
                },
                alignLeft: function() {
                    nyasa.container.addClass("aside-left"), nyasa.aside.jasmineAffix("update")
                },
                alignRight: function() {
                    nyasa.container.removeClass("aside-left"), nyasa.aside.jasmineAffix("update")
                },
                togglePosition: function() {
                    nyasa.container.toggleClass("aside-fixed"), nyasa.aside.jasmineAffix("update")
                },
                fixedPosition: function() {
                    nyasa.container.addClass("aside-fixed"), nyasa.aside.jasmineAffix("update")
                },
                staticPosition: function() {
                    nyasa.container.removeClass("aside-fixed"), nyasa.aside.jasmineAffix("update")
                },
                toggleTheme: function() {
                    nyasa.container.toggleClass("aside-bright")
                },
                brightTheme: function() {
                    nyasa.container.addClass("aside-bright")
                },
                darkTheme: function() {
                    nyasa.container.removeClass("aside-bright")
                }
            },
            x = function() {
                nyasa.container.hasClass("mainnav-in") && "xs" != nyasa.screenSize && ("sm" == nyasa.screenSize ? $.nyasaNav("collapse") : nyasa.container.removeClass("mainnav-in mainnav-lg mainnav-sm").addClass("mainnav-out"))
            };

        $.nyasaAside = function(a, b) {
                return w[a] && (w[a].apply(this, Array.prototype.slice.call(arguments, 1)), b) ? b() : null
            },


            /* ========================================================================
             * nyasa AFFIX v1.0
             * -------------------------------------------------------------------------
             * Require Bootstrap Affix
             * http://getbootstrap.com/javascript/#affix
             * ========================================================================*/

            $.fn.jasmineAffix = function(a) {
                return this.each(function() {
                    var c, b = $(this);
                    "object" != typeof a && a ? "update" == a && (c = b.data("nyasa.af.class")) : (c = a.className, b.data("nyasa.af.class", a.className)), nyasa.container.hasClass(c) && !nyasa.container.hasClass("navbar-fixed") ? b.affix({
                        offset: {
                            top: $("#navbar").outerHeight()
                        }
                    }) : nyasa.container.hasClass(c) && !nyasa.container.hasClass("navbar-fixed") || (nyasa.window.off(b.attr("id") + ".affix"), b.removeClass("affix affix-top affix-bottom").removeData("bs.affix"))
                })
            },


            $(".inbox-star").click(function() {
                $(this).toggleClass("starred")
            }),

            $("#profilebtn").click(function() {
                $("#profilebody").slideToggle()
            }),

            $(".conversation-toggle").on("click", function() {
                $(".conversation").toggleClass("closed")
            });

        var y = Array.prototype.slice.call(document.querySelectorAll(".demo-switch"));
        y.forEach(function(a) {
                new Switchery(a)
            }),


            // FULLSCREEN
            // =================================================================
            // Toggle fullscreen
            // =================================================================

            $('[data-toggle="fullscreen"]').click(function() {
                return screenfull.enabled && screenfull.toggle(), !1
            }), screenfull.enabled && document.addEventListener(screenfull.raw.fullscreenchange, function() {
                $('[data-toggle="fullscreen"]').toggleClass("active", screenfull.isFullscreen)
            })

    }),

    ! function(a, b) {
        var c = {};
        c.eventName = "resizeEnd", c.delay = 250, c.poll = function() {
            var d = a(this),
                e = d.data(c.eventName);
            e.timeoutId && b.clearTimeout(e.timeoutId), e.timeoutId = b.setTimeout(function() {
                d.trigger(c.eventName)
            }, c.delay)
        }, a.event.special[c.eventName] = {
            setup: function() {
                var b = a(this);
                b.data(c.eventName, {}), b.on("resize", c.poll)
            },
            teardown: function() {
                var d = a(this),
                    e = d.data(c.eventName);
                e.timeoutId && b.clearTimeout(e.timeoutId), d.removeData(c.eventName), d.off("resize", c.poll)
            }
        }, a.fn[c.eventName] = function(a, b) {
            return arguments.length > 0 ? this.on(c.eventName, null, a, b) : this.trigger(c.eventName)
        }
    }(jQuery, this);