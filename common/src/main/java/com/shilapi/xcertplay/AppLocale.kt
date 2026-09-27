// SPDX-License-Identifier: AGPL-3.0-only
package com.shilapi.xcertplay

import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.app.AlertDialog
import java.util.Locale

/** App language preference and the Chinese copy for the programmatically built UI. */
object AppLocale {
    const val SYSTEM = "system"
    const val ENGLISH = "en"
    const val SIMPLIFIED_CHINESE = "zh"

    private const val PREFS = "diplay"
    private const val KEY_LANGUAGE = "app_language"

    private val chinese = mapOf(
        "Car home" to "车机主页", "Back" to "返回", "YOUR PHONE. YOUR DRIVE." to "你的手机，畅享旅程。",
        "A familiar drive." to "熟悉的驾乘体验。",
        "Your maps, music and conversations.\nCarPlay, right here on your car display." to "地图、音乐与通话，\n在车机屏幕上畅享 CarPlay。",
        "WIRELESS CARPLAY" to "无线 CarPlay", "Ready when you are" to "一切就绪",
        "Connect phone" to "连接手机",
        "Pair your iPhone with the car’s Bluetooth, then connect.\nKeep Bluetooth and Wi-Fi on." to "先在车机蓝牙设置中配对 iPhone，再连接。\n请保持蓝牙和 Wi-Fi 开启。",
        "Open car hotspot settings" to "打开车机热点设置", "Choose iPhone" to "选择 iPhone",
        "Disconnect" to "断开连接", "Connect with USB" to "通过 USB 连接",
        "Plug your iPhone into a USB data port.\nAllow CarPlay when your iPhone asks." to "将 iPhone 连接到支持数据传输的 USB 接口。\n手机出现提示时允许使用 CarPlay。",
        "Settings" to "设置", "Make DiPlay feel right for your car." to "按需调整 DiPlay 设置。",
        "Your drive, your way." to "按你的习惯设置。",
        "Apply reconnects CarPlay for size, resolution, music buffer and frame rate. Other changes apply to your next connection." to "应用尺寸、分辨率、音乐缓冲和帧率设置时会重新连接 CarPlay。其他改动将在下次连接时生效。",
        "Language" to "语言", "App language" to "应用语言", "System default" to "跟随系统",
        "Use the device language when supported; otherwise use English." to "系统语言为中文时使用中文，其他情况使用英文。",
        "Apply" to "应用", "Automatic connection" to "自动连接",
        "Connect when DiPlay opens" to "打开 DiPlay 时连接",
        "Use your last connection type and selected iPhone." to "使用上次的连接方式和已选 iPhone。",
        "Open after the car starts" to "车机启动后打开",
        "Availability depends on your head unit’s startup settings." to "是否可用取决于车机的启动设置。",
        "Wireless connection" to "无线连接", "Display and performance" to "显示与性能",
        "Resolution" to "分辨率", "Native" to "原生", "80% · lighter load" to "80% · 减轻负载",
        "60% · lightest load" to "60% · 最低负载", "Music buffer" to "音乐缓冲",
        "300 ms · default" to "300 毫秒 · 默认", "500 ms" to "500 毫秒",
        "1000 ms · most stable" to "1000 毫秒 · 更稳定", "Frame rate" to "帧率",
        "30 fps · lighter load" to "30 帧/秒 · 减轻负载", "60 fps · smoother motion" to "60 帧/秒 · 更流畅",
        "Efficient video" to "高效视频", "Use HEVC. Leave off for the widest head-unit compatibility." to "使用 HEVC。关闭后可兼容更多车机。",
        "Right-hand drive" to "右舵模式", "Place CarPlay’s controls closer to the driver." to "将 CarPlay 控件移至更靠近驾驶员的一侧。",
        "Full screen" to "全屏显示", "Hide the car’s system bars while CarPlay is open." to "打开 CarPlay 时隐藏车机系统栏。",
        "BYD navigation" to "比亚迪导航", "Navigation on HUD and instrument cluster" to "在 HUD 和仪表盘显示导航",
        "Show phone navigation arrows, distance and street names on supported BYD displays. Vehicle compatibility varies." to "在支持的比亚迪显示屏上显示手机导航箭头、距离和道路名称。不同车型的兼容性有所差异。",
        "Permissions and connection help" to "权限与连接帮助",
        "Nearby devices connects your iPhone. Microphone enables Siri and calls. Older Android versions also require Location for wireless setup. USB mode may ask for a local VPN connection." to "“附近的设备”权限用于连接 iPhone；麦克风权限用于 Siri 和通话。较旧的 Android 版本还需要位置权限来设置无线连接。USB 模式可能会请求建立本地 VPN 连接。",
        "App permissions" to "应用权限", "Bluetooth settings" to "蓝牙设置", "Wireless connection help" to "无线连接帮助",
        "About and diagnostics" to "关于与诊断", "About DiPlay" to "关于 DiPlay",
        "Saving report…" to "正在保存报告…", "Save diagnostic report" to "保存诊断报告",
        "Reports save to Downloads/DiPlay. " to "报告将保存到 Downloads/DiPlay。",
        "Choose where to save your report. " to "选择报告的保存位置。",
        "Nothing is sent automatically. Protocol payloads and credentials are excluded." to "报告不会自动发送，不包含协议数据和凭据。",
        "CarPlay, at home in your car." to "让 CarPlay 融入车机。",
        "An independent CarPlay receiver for Android head units. Wired and wireless connections run on the head unit, with local authentication. A standard iPhone can connect without a jailbreak, Mac, dongle or sign-in.\n\nThis preview uses an experimental accessory identity. Compatibility with every iPhone and head unit is still being tested. It is not an Apple-certified product." to "面向 Android 车机的独立 CarPlay 接收器。有线和无线连接均在车机上运行，并使用本地认证。普通 iPhone 无需越狱、Mac、转接器或登录即可连接。\n\n此预览版使用实验性配件身份，仍在测试与不同 iPhone 和车机的兼容性。本产品未经 Apple 认证。",
        "Made possible by open source" to "开源项目鸣谢",
        "Receiver based on xcertplay, licensed under GPL-3.0. DiPlay’s interface follows DiAuto’s design, licensed under AGPL-3.0.\n\nIncludes AndroidX, Bouncy Castle, JmDNS and SLF4J. Source and license notices accompany this release.\n\nCarPlay and the CarPlay icon belong to Apple Inc. DiPlay is an independent project." to "接收器基于采用 GPL-3.0 许可的 xcertplay。DiPlay 界面沿用采用 AGPL-3.0 许可的 DiAuto 设计。\n\n项目包含 AndroidX、Bouncy Castle、JmDNS 和 SLF4J。本版本附有源代码和许可声明。\n\nCarPlay 和 CarPlay 图标归 Apple Inc. 所有。DiPlay 是独立项目。",
        "Car hotspot is off" to "车机热点未开启",
        "Open car settings" to "打开车机设置", "Connect" to "连接", "Cancel" to "取消",
        "Wireless link" to "无线连接方式", "Wi-Fi Direct · default" to "Wi-Fi Direct · 默认",
        "Car hotspot" to "车机热点", "Apply and reconnect" to "应用并重新连接", "Save" to "保存",
        "DiPlay creates its own Wi-Fi Direct network for the iPhone." to "DiPlay 会为 iPhone 创建独立的 Wi-Fi Direct 网络。",
        "Car hotspot name" to "车机热点名称", "Car hotspot password" to "车机热点密码", "none" to "无",
        "Turn on the hotspot in the car settings first and enter the same name and password here. The iPhone joins this network for CarPlay. Changes apply to your next connection." to "请先在车机设置中开启热点，再在此输入相同的名称和密码。iPhone 将连接此网络以使用 CarPlay。更改将在下次连接时生效。",
        "CarPlay size" to "CarPlay 尺寸",
        "Changes the size of CarPlay icons and text. Applying a size reconnects CarPlay." to "更改 CarPlay 图标和文字的大小。应用尺寸后会重新连接 CarPlay。",
        "Turn on Bluetooth" to "打开蓝牙", "Enable the car’s Bluetooth and pair your iPhone first." to "请先打开车机蓝牙并配对 iPhone。",
        "Open Bluetooth" to "打开蓝牙", "Later" to "稍后", "Pair your iPhone" to "配对 iPhone",
        "On your iPhone, open Settings → Bluetooth and pair with the car. Then return to DiPlay and choose Connect phone." to "在 iPhone 上打开“设置 → 蓝牙”并与车机配对。然后返回 DiPlay，点击“连接手机”。",
        "Got it" to "知道了", "Choose your iPhone" to "选择 iPhone", "Paired device" to "已配对设备",
        "Pair another" to "配对其他设备", "Reset CarPlay Wi-Fi" to "重置 CarPlay Wi-Fi",
        "Pair your iPhone with the car’s Bluetooth, keep Wi-Fi on, and allow CarPlay on the iPhone. Close any other phone-projection app.\n\nIf a previous projection app left its connection running, reset CarPlay Wi-Fi below and connect again. Your car’s normal internet Wi-Fi stays on." to "在车机蓝牙设置中配对 iPhone，保持 Wi-Fi 开启，并在 iPhone 上允许 CarPlay。请关闭其他手机投屏应用。\n\n如果之前的投屏应用残留了连接，请先重置下方的 CarPlay Wi-Fi，再重新连接。车机正常的互联网 Wi-Fi 不受影响。",
        "Reset CarPlay Wi-Fi?" to "重置 CarPlay Wi-Fi？",
        "This ends the existing Wi-Fi Direct connection, including one left behind after reinstalling. Close other projection apps first. Your car’s internet Wi-Fi stays on." to "这会结束现有的 Wi-Fi Direct 连接，包括重新安装后遗留的连接。请先关闭其他投屏应用。车机的互联网 Wi-Fi 不受影响。",
        "Reset and connect" to "重置并连接", "This head unit does not support Wi-Fi Direct." to "此车机不支持 Wi-Fi Direct。",
        "Wi-Fi Direct is still busy. Close the other projection app and try again." to "Wi-Fi Direct 仍被占用。请关闭其他投屏应用后重试。",
        "Could not reset Wi-Fi Direct. Close the other projection app and try again." to "无法重置 Wi-Fi Direct。请关闭其他投屏应用后重试。",
        "Wireless permissions" to "无线连接权限", "Allow Nearby devices and, on older Android versions, Location before resetting CarPlay Wi-Fi." to "重置 CarPlay Wi-Fi 前，请授予“附近的设备”权限；较旧的 Android 版本还需要位置权限。",
        "Setup needs attention" to "设置需要处理", "CarPlay connected" to "CarPlay 已连接",
        "Connecting to your iPhone…" to "正在连接 iPhone…", "Ready for " to "已准备连接：",
        "Open CarPlay" to "打开 CarPlay", "This head unit could not open a save location. Please try saving to Downloads again." to "车机无法打开保存位置，请重试保存到 Downloads。",
        "This head unit has no available file picker to save the report." to "此车机没有可用于保存报告的文件选择器。",
        "Diagnostic report saved" to "诊断报告已保存", "Your report was saved to the selected location." to "报告已保存到所选位置。",
        "Done" to "完成", "Could not save the report" to "无法保存报告",
        "Check that storage is available, or choose another save location." to "请检查存储空间，或选择其他保存位置。",
        "Choose location" to "选择位置", "Close" to "关闭", "App settings" to "应用设置",
        "Open this setting from your car’s Settings app." to "请在车机的设置应用中打开此设置。",
        "Nearby devices" to "附近的设备",
        "Allow Nearby devices so DiPlay can connect to your paired iPhone." to "请允许 DiPlay 访问附近的设备，以连接已配对的 iPhone。",
        "Getting CarPlay ready…" to "正在准备 CarPlay…",
        "Keep your iPhone nearby with Bluetooth and Wi-Fi on.\nAllow CarPlay if your iPhone asks." to "请将 iPhone 放在附近并开启蓝牙和 Wi-Fi。\niPhone 出现提示时允许使用 CarPlay。",
        "Use a USB data cable and unlock your iPhone.\nAllow Trust and CarPlay if your iPhone asks." to "请使用 USB 数据线并解锁 iPhone。\niPhone 出现提示时允许“信任”和使用 CarPlay。",
        "Reset CarPlay Wi-Fi" to "重置 CarPlay Wi-Fi", "Back to DiPlay" to "返回 DiPlay",
        "In CarPlay, swipe down with three fingers to open DiPlay settings." to "在 CarPlay 界面用三指向下滑动，可打开 DiPlay 设置。",
        "CarPlay settings" to "CarPlay 设置", "Connection" to "连接", "Wireless CarPlay" to "无线 CarPlay",
        "Wireless CarPlay transport" to "无线 CarPlay 连接", "Hotspot status" to "热点状态",
        "Location" to "位置", "Startup" to "启动", "Auto-start on boot" to "开机后自动启动",
        "Start CarPlay automatically after device boot" to "设备启动后自动启动 CarPlay", "Audio" to "音频",
        "Advanced audio channel mapping" to "高级音频通道映射", "Route AAOS audio buses by CarPlay audio type" to "按 CarPlay 音频类型路由 AAOS 音频总线",
        "Identity & appearance" to "身份与外观", "Display & video" to "显示与视频",
        "Frame rate" to "帧率", "Physical size basis" to "物理尺寸依据", "Widest width" to "较宽边",
        "Longest height" to "较长边", "Physical length" to "物理长度", "HEVC software decoder" to "HEVC 软件解码器",
        "Use software HEVC decoder" to "使用 HEVC 软件解码器", "Window" to "窗口", "Diagnostics" to "诊断",
        "Android 9 compatibility" to "Android 9 兼容性",
        "The following settings are unavailable and hidden on Android 9 (API 28):\n• Wi-Fi P2P (5 GHz) — LocalOnlyHotspot is used instead.\n• HEVC software decoder — hardware decoding is used instead." to "以下设置在 Android 9（API 28）上不可用且已隐藏：\n• Wi-Fi P2P（5 GHz）— 将改用 LocalOnlyHotspot。\n• HEVC 软件解码器 — 将改用硬件解码。",
        "Save and reconnect" to "保存并重新连接", "EXIT APPLICATION" to "退出应用",
        "Discard changes and exit settings" to "放弃更改并退出设置",
        "I2C device" to "I2C 设备", "Linux device path, for example /dev/i2c-1." to "Linux 设备路径，例如 /dev/i2c-1。",
        "Server address" to "服务器地址", "Token (optional)" to "令牌（可选）",
        "Address must start with http:// or https://. Token is optional and sent as an Authorization bearer token." to "地址必须以 http:// 或 https:// 开头。令牌为可选项，并会作为 Authorization bearer token 发送。",
        "Manufacturer" to "制造商", "Model" to "型号", "OEM label" to "OEM 标签",
        "Report location to iPhone" to "向 iPhone 报告位置", "Report Android location to the iPhone" to "向 iPhone 报告 Android 位置",
        "Sends precise Android location as CarPlay GPS data when the iPhone requests it." to "iPhone 请求时，将 Android 精确位置作为 CarPlay GPS 数据发送。",
        "Debug logs" to "调试日志", "Show on-screen debug logs" to "在屏幕上显示调试日志",
        "AirPlay icon" to "AirPlay 图标", "Choose image" to "选择图片", "Default icon" to "默认图标",
        "Driving side" to "驾驶方向", "Left-hand drive" to "左舵", "Right-hand drive" to "右舵",
        "Fullscreen" to "全屏", "Hide top bar" to "隐藏顶部状态栏", "Hide the status bar" to "隐藏状态栏",
        "Hide bottom bar" to "隐藏底部导航栏", "Hide the navigation bar" to "隐藏导航栏",
        "Safe area" to "安全区域", "Set" to "设置", "Reset" to "重置",
        "Draw outside safe area" to "允许绘制到安全区域外", "Allow CarPlay UI outside the safe area" to "允许 CarPlay 界面超出安全区域",
        "Wi-Fi session" to "Wi-Fi 会话", "Wi-Fi P2P (5 GHz)" to "Wi-Fi P2P（5 GHz）",
        "Manual hotspot" to "手动热点", "Band" to "频段", "Auto" to "自动",
        "Channel (0 = auto)" to "信道（0 = 自动）", "Hotspot SSID" to "热点 SSID",
        "Hotspot password" to "热点密码", "Security" to "安全类型",
        "Open" to "开放", "WPA3 transition" to "WPA3 过渡模式", "Local offline" to "本地离线",
        "Remote" to "远程", "Wired" to "有线", "Wireless" to "无线",
        "Loading image" to "正在加载图片", "Cancel" to "取消", "Save 1:1" to "保存 1:1 图片",
        "Could not decode image" to "无法读取图片", "Drag to move, pinch to zoom" to "拖动以移动，双指缩放",
        "Image is not ready" to "图片尚未准备好", "Could not encode image" to "无法编码图片",
        "Could not save image" to "无法保存图片",
        "Hotspot SSID is required" to "必须填写热点 SSID", "Hotspot SSID must be at most 32 UTF-8 bytes" to "热点 SSID 最多为 32 个 UTF-8 字节",
        "Hotspot SSID contains U+0000" to "热点 SSID 包含 U+0000", "Channel must be 0 or 1-196" to "信道必须为 0 或 1–196",
        "Channel is not valid for the selected band" to "所选频段不支持此信道", "Hotspot password contains U+0000" to "热点密码包含 U+0000",
        "Password must be empty when security is Open" to "安全类型为“开放”时，密码必须留空",
        "WPA2/WPA3 password must be 8-63 characters" to "WPA2/WPA3 密码长度必须为 8–63 个字符",
        "I2C device path is required" to "必须填写 I2C 设备路径", "Remote server address is required" to "必须填写远程服务器地址",
        "Remote server address must start with http:// or https://" to "远程服务器地址必须以 http:// 或 https:// 开头",
        "I2C device path contains U+0000" to "I2C 设备路径包含 U+0000", "Remote server address contains U+0000" to "远程服务器地址包含 U+0000",
        "Remote token contains U+0000" to "远程令牌包含 U+0000", "Wireless hotspot: off" to "无线热点：关闭",
        "Wireless hotspot: " to "无线热点：", "SSID" to "网络名称", "Backend" to "后端", "Band" to "频段",
        "Channel" to "信道", "Large" to "大", "Medium" to "中", "Small" to "小", "Smaller" to "更小",
        "Default" to "默认", "Custom 1:1 icon" to "自定义 1:1 图标", "Default placeholder icon" to "默认占位图标",
        "Local" to "本地", "USB/CH341" to "USB/CH341", "Widest width" to "较宽边", "Longest height" to "较长边",
        "MFi target" to "MFi 目标", "USB/CH341" to "USB/CH341", "I2C" to "I2C", "I2C device path" to "I2C 设备路径",
        "Physical length" to "物理长度", "Display resolution" to "显示分辨率", "Physical size" to "物理尺寸",
        "Save changes" to "保存更改",
        "Exit application" to "退出应用", "Connected" to "已连接", "Disconnected" to "已断开",
        "Wi-Fi P2P (5 GHz)" to "Wi-Fi P2P（5 GHz）",
        "LocalOnlyHotspot" to "LocalOnlyHotspot", "WPA2" to "WPA2", "WPA3" to "WPA3",
        "1:1 icon" to "1:1 图标", "Save 1:1" to "保存 1:1 图片",
        "Local setup could not finish. Reinstall the complete DiPlay beta APK and try again." to "本地设置未能完成。请重新安装完整的 DiPlay Beta APK 后重试。",
        "CarPlay" to "CarPlay", "CarPlay icon" to "CarPlay 图标",
        "HEVC H.265 video transport" to "HEVC H.265 视频传输",
        "The current AirPlay icon could not be used. Choose another image." to "当前 AirPlay 图标无法使用，请选择其他图片。",
        "This head unit cannot use the smaller size at this resolution. Using Default." to "此车机在当前分辨率下无法使用更小的尺寸，将使用默认尺寸。",
        "Safe area: waiting for activity size" to "安全区域：正在等待活动窗口尺寸",
        "30 fps" to "30 帧/秒", "60 fps" to "60 帧/秒",
        "Security" to "安全类型", "WPA2" to "WPA2", "WPA3" to "WPA3", "2.4 GHz" to "2.4 GHz", "5 GHz" to "5 GHz",
        "MFI certificate & signing target" to "MFi 证书与签名目标", "Local offline" to "本地离线",
        "Starting" to "正在启动", "Ready" to "就绪", "Waiting for paired iPhone" to "正在等待已配对的 iPhone",
        "Connecting Bluetooth" to "正在连接蓝牙", "Running" to "运行中", "Active" to "已启用",
        "Starting AirPlay service" to "正在启动 AirPlay 服务", "Error" to "错误",
        "Handshake resolution: waiting for display" to "握手分辨率：正在等待显示屏",
        "top hidden" to "顶部已隐藏", "top shown" to "顶部已显示", "bottom hidden" to "底部已隐藏", "bottom shown" to "底部已显示",
        "right" to "右侧", "left" to "左侧", "enabled" to "已启用", "disabled" to "已停用",
        "Starting wireless hotspot" to "正在启动无线热点", "Waiting for iPhone over USB" to "正在等待 USB 连接的 iPhone",
        "Requesting iPhone USB permission" to "正在请求 iPhone USB 权限", "Pairing with iPhone" to "正在与 iPhone 配对",
        "Connecting iAP2 control" to "正在连接 iAP2 控制通道", "Opening USB data paths" to "正在打开 USB 数据通道",
        "Selecting CarPlay configuration" to "正在选择 CarPlay 配置", "Discovering iPhone" to "正在查找 iPhone",
        "Discovering MFi authentication" to "正在查找 MFi 认证设备", "Preparing MFi authentication" to "正在准备 MFi 认证",
        "Waiting for MFi coprocessor" to "正在等待 MFi 协处理器", "Requesting MFi USB permission" to "正在请求 MFi USB 权限",
        "MFi authentication ready" to "MFi 认证已就绪", "Running CarPlay control" to "CarPlay 控制通道运行中",
        "Wireless CarPlay control running" to "无线 CarPlay 控制通道运行中", "Wireless CarPlay active" to "无线 CarPlay 已启用",
        "CarPlay control running" to "CarPlay 控制通道运行中", "CarPlay control window ended" to "CarPlay 控制会话已结束",
        "Could not start CarPlay. Return to DiPlay and check app permissions." to "无法启动 CarPlay。请返回 DiPlay 检查应用权限。",
        "Turn on Wi-Fi in the head unit’s settings to connect." to "请在车机设置中打开 Wi-Fi 后再连接。",
        "Allow precise Location for DiPlay in the head unit’s app permissions." to "请在车机应用权限中允许 DiPlay 使用精确位置信息。",
        "Allow Nearby devices for DiPlay in the head unit’s app permissions." to "请在车机应用权限中允许 DiPlay 访问附近的设备。",
        "The head unit couldn’t start CarPlay Wi-Fi. Check Wi-Fi and close other projection apps. Retrying…" to "车机无法启动 CarPlay Wi-Fi。请检查 Wi-Fi 并关闭其他投屏应用，正在重试…",
        "A previous Wi-Fi Direct connection is still running. Reset it to connect." to "之前的 Wi-Fi Direct 连接仍在运行。请重置后再连接。",
        "Your iPhone isn’t available. Unlock it and check Bluetooth." to "暂时找不到 iPhone。请解锁手机并检查蓝牙。",
        "This head unit may not support wireless CarPlay. Try a USB connection." to "此车机可能不支持无线 CarPlay，请尝试 USB 连接。",
        "Allow the connection permission to continue" to "请授予连接权限以继续",
        "Connection interrupted. Retrying…" to "连接中断，正在重试…", "Connect your iPhone with a USB cable" to "请使用 USB 数据线连接 iPhone",
        "Looking for your paired iPhone…" to "正在查找已配对的 iPhone…", "Connecting to your iPhone…" to "正在连接 iPhone…",
        "Reconnecting to your iPhone…" to "正在重新连接 iPhone…", "Opening CarPlay…" to "正在打开 CarPlay…",
    )

    fun preference(context: Context): String =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getString(KEY_LANGUAGE, SYSTEM) ?: SYSTEM

    fun save(context: Context, language: String) {
        require(language in setOf(SYSTEM, ENGLISH, SIMPLIFIED_CHINESE))
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putString(KEY_LANGUAGE, language).apply()
    }

    fun effectiveLanguage(context: Context): String = when (preference(context)) {
        ENGLISH -> ENGLISH
        SIMPLIFIED_CHINESE -> SIMPLIFIED_CHINESE
        else -> if (systemLanguage(context).startsWith("zh", ignoreCase = true)) SIMPLIFIED_CHINESE else ENGLISH
    }

    fun displayName(context: Context, language: String = preference(context)): String = when (language) {
        SYSTEM -> text(context, "System default")
        ENGLISH -> "English"
        SIMPLIFIED_CHINESE -> "简体中文"
        else -> "English"
    }

    fun wrap(context: Context): Context {
        val language = preference(context)
        val locale = when (language) {
            ENGLISH -> Locale.ENGLISH
            SIMPLIFIED_CHINESE -> Locale.SIMPLIFIED_CHINESE
            else -> return context
        }
        val configuration = Configuration(context.resources.configuration).apply {
            setLocale(locale)
            setLayoutDirection(locale)
        }
        return context.createConfigurationContext(configuration)
    }

    fun text(context: Context, source: String): String {
        if (effectiveLanguage(context) != SIMPLIFIED_CHINESE) return source
        chinese[source]?.let { return it }
        when {
            source.startsWith("PUBLIC PREVIEW  · ") -> return "公开预览  · ${source.substringAfter(" · ")}"
            source.startsWith("Public preview · ") -> return "公开预览 · ${source.substringAfter(" · ")}"
            source.startsWith("Choose iPhone · ") -> return "选择 iPhone · ${source.substringAfter(" · ")}"
            source.startsWith("Hotspot name · ") -> return "热点名称 · ${source.substringAfter(" · ")}"
            source.startsWith("Hotspot password · ") -> return "热点密码 · ${text(context, source.substringAfter(" · "))}"
            source.startsWith("Ready for ") -> return "已准备连接：${source.removePrefix("Ready for ")}"
            source.startsWith("The car hotspot “") && source.endsWith("” is off. Turn it on in the car settings before connecting.") ->
                return "车机热点“${source.substringAfter("The car hotspot “").substringBefore("” is off.")}”未开启。请在车机设置中开启后再连接。"
            source.startsWith("DiPlay connects through the car hotspot “") ->
                return "DiPlay 通过车机热点“${source.substringAfter("DiPlay connects through the car hotspot “").substringBefore("”")}”连接。请在车机设置中开启热点后再连接。"
            source.startsWith("Wireless link · ") -> return "无线连接方式 · ${text(context, source.substringAfter(" · "))}"
            source.startsWith("Hotspot status") -> return "热点状态"
        }
        if (source.contains('\n')) {
            val prefixes = listOf(
                "Wireless hotspot: " to "无线热点：", "SSID: " to "网络名称：", "Backend: " to "后端：",
                "Band: " to "频段：", "Channel: " to "信道：", "Handshake resolution: " to "握手分辨率：",
                "Identity: " to "身份：", "OEM label: " to "OEM 标签：", "Frame rate: " to "帧率：",
                "Detected maximum: " to "检测到的最大分辨率：", "Physical reference: " to "物理尺寸参考：",
                "CarPlay physical size: " to "CarPlay 物理尺寸：", "Driving side: " to "驾驶方向：",
                "Fullscreen: " to "全屏：", "Video transport: " to "视频传输：",
                "Location reporting: " to "位置上报：", "Audio channel mapping: " to "音频通道映射：",
                "Safe area: " to "安全区域：",
            )
            return source.lines().joinToString("\n") { line ->
                val prefix = prefixes.firstOrNull { line.startsWith(it.first) }
                if (prefix == null) line else prefix.second + text(context, line.removePrefix(prefix.first))
            }
        }
        if (source.startsWith("Safe area: full screen at ")) {
            return "安全区域：全屏，${source.removePrefix("Safe area: full screen at ")}"
        }
        if (source.startsWith("Safe area: ")) return "安全区域：${source.removePrefix("Safe area: ")}"
        return source
    }

    private fun systemLanguage(context: Context): String =
        context.resources.configuration.locales[0]?.language ?: Locale.getDefault().language
}

/** Applies app translations to the text passed to native Android alert dialogs. */
class AppAlertDialogBuilder(private val owner: Context) : AlertDialog.Builder(owner) {
    override fun setTitle(title: CharSequence?): AlertDialog.Builder =
        super.setTitle(title?.let { AppLocale.text(owner, it.toString()) })

    override fun setMessage(message: CharSequence?): AlertDialog.Builder =
        super.setMessage(message?.let { AppLocale.text(owner, it.toString()) })

    override fun setPositiveButton(
        text: CharSequence?,
        listener: DialogInterface.OnClickListener?,
    ): AlertDialog.Builder = super.setPositiveButton(
        text?.let { AppLocale.text(owner, it.toString()) }, listener,
    )

    override fun setNegativeButton(
        text: CharSequence?,
        listener: DialogInterface.OnClickListener?,
    ): AlertDialog.Builder = super.setNegativeButton(
        text?.let { AppLocale.text(owner, it.toString()) }, listener,
    )

    override fun setNeutralButton(
        text: CharSequence?,
        listener: DialogInterface.OnClickListener?,
    ): AlertDialog.Builder = super.setNeutralButton(
        text?.let { AppLocale.text(owner, it.toString()) }, listener,
    )
}
