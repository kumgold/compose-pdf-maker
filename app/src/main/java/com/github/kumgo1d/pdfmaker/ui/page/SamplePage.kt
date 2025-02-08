package com.github.kumgo1d.pdfmaker.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.kumgo1d.pdfmaker.PdfScanner

@Composable
fun SamplePage() {
    val isChecked = remember { mutableStateOf(false) }

    PdfScanner {
        Column {
            Checkbox(
                checked = isChecked.value,
                onCheckedChange = {
                    isChecked.value = it
                }
            )
            SampleText()
            SampleText()
            SampleText()
        }
    }
}

@Composable
fun SampleText(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.padding(10.dp),
        text = """
            Android는 Linux 커널을 기반으로 Google에서 제작하고 있는 범용 모바일 운영 체제와 미들웨어 및 중요 애플리케이션이 포함된 배포판이다. Google은 새로운 운영 체제의 버전 공개와 동시에 소스를 공개하고 있다. 이렇게 공개된 소스를 AOSP라고 한다.

            의외로 많이들 지나치는 사실이지만 원래는 Google에서 개발한 운영 체제가 아니다. 앤디 루빈이 설립한 Android Inc.에서 개발했으며 이후 Google이 이 회사를 인수하여 구글에서 개발을 하고 있다. 초창기의 Android는 여기서 디지털 카메라의 운영 체제로 출발했으며, iPhone 등 경쟁 스마트폰이 나온 이후 스마트폰 운영 체제로 개발 방향을 바꾸게 되었다.[3]

            Android는 세계에서 가장 대표적인 오픈 소스 플랫폼이며 세계 최다 사용자를 보유한 모바일 운영 체제다. 소스코드 공식 사이트 2008년 9월에 1.0 버전이 첫 등장 했다.

            개방성과 범용성이 뛰어나 여러 플랫폼으로 이식 및 개발이 가능하다.

            2021년 기준 Android(72.20%)와 iOS 점유율(26.99%)을 합치면 99.18%이다. 스마트폰 OS 점유율 3위였던 Windows Phone의 점유율조차 0.02%까지 떨어져서[4] 결국 Microsoft에서도 모바일 운영 체제 시장 포기를 선언하였고[5] 모바일 OS 시장은 Android와 iOS로 정리되었다. iOS는 Apple 전용 운영 체제이고 KaiOS는 피쳐폰 전용 OS니 사실상 아이폰과 하모니 OS[6]를 탑재한 화웨이를 제외한 시장에 출시된 모든 스마트폰에 탑재되어 있는 셈이다. 자세한 내용은 운영 체제/점유율 문서를 참조.
            
            기본적으로는 ARM 프로세서로 포팅되어 있으며 MIPS, Power Architecture, x86-64로도 포팅이 되어 있다. 지원하는 언어는 커널 쪽은 C, 몇몇 라이브러리는 C++, 그리고 UI 및 응용 소프트웨어는 Java로 되어있다.[10] 가상 머신은 Java VM이 아니라 자체 개발한 Dalvik VM을 사용한다.[11] 이후 4.4에서 ART가 개발자용으로 탑재되었고 AOSP 4.4 ART 기본값 기사 5.0에서는 기본으로 사용하도록 하여 Dalvik을 완전히 대체하였다.[12]

            Linux 커널을 기반으로 한 OS이고 Java 가상 머신을 사용하여 성능은 좀 떨어질지라도[13] 호환성 하나는 막강하여[14] ARM 코어 프로세서뿐만 아니라 다른 플랫폼으로도 포팅이 가능해 스마트폰, PMP는 물론이고 태블릿 컴퓨터, 텔레비전 심지어 PC에도 포팅이 가능하다. 비교적 자원이 부족한 모바일 운영체제임에도 불구하고 효율성 대신 범용성을 중시한다는 점이 다소 의아하겠지만 Android는 이를 이용해 단순 OS를 넘어서 플랫폼으로써의 지위를 갖게 되었고, 막강한 시장성을 확보할 수 있었다.

            실제로도 Android는 Linux를 기반으로 한 OS뿐만 아니라 그 위에서 돌아가는 각종 소프트웨어 스택까지 다 포함되므로 생각보다 훨씬 큰 개념이다. 따라서 최하단의 Linux 커널을 다른 OS 커널로 교체하더라도 상위의 다른 서비스들을 전부 동일하게 돌릴 수만 있으면 우리가 아는 Android를 다른 운영체제 기반으로도 동작시킬 수 있다. 대표적으로 Windows 커널 기반으로 동작하는 Windroye(구 WindowsAndroid)가 있다.

            반대로 Android 앱은 비록 Android OS가 Linux 커널 기반이라지만 엄연히 수정이 가해졌을뿐더러 상위의 가상머신, 프레임워크, 라이브러리 등의 구동 환경 자체가 없고 가상머신의 지원이 없이는 애초에 네이티브 실행이 되는 코드조차도 아니므로 이론상으로도 다른 Linux 운영체제에서 직접 구동은 할 수 없다. 예를 들면 Linux에서는 GUI를 만들기 위해 X11 라이브러리를 사용하지만 Android에서는 이걸 쓰지 않고 자체 GUI 라이브러리를 사용하므로 GUI Linux 프로그램은 Android에서 실행할 수 없다.

            라이선스는 아파치 라이선스 2.0을 사용한다. 단, Linux 커널을 수정한 부분에 대해서는 GPL 2.0이 적용된다.

            모든 Android 기반 기기에서 Google 서비스를 사용할 수는 없다. Android 기기에서 Google 서비스를 지원하기 위해서는 Google Android 인증이 필요한데 이 인증 조건에 터치스크린, GPS, 카메라 등등의 일부 하드웨어가 반드시 필요하기 때문에 사실상 스마트폰이나 태블릿 컴퓨터 등등 그런 구성이 허용되는 기기 이외에는 인증을 받기가 어렵다. 이것은 Google이 단순히 심술을 부리는게 아니라 애초에 그런 하드웨어 구성을 상정하고 있기 때문이다.

            물론 인증을 받지 않더라도 Google의 서비스를 이용 못 할 뿐이지 Android 자체를 사용하는 데는 지장이 없다. Android 역시 이런 상황에 대처하기 위해 Google의 서비스 없이도 Android가 돌아갈 수 있는 여러 장치를 해뒀지만 그래도 Google의 서비스가 없는 Android를 소비자가 얼만큼 반길지는 의문이다. 게다가 Google이 인증하지 않은 Android는 'Android'라는 상표나 명칭도 못쓴다. 이런 것들은 AOSP라고 따로 불린다. 지금 기준으로 보면 Android라는 상표권과 인증 여건 때문에 Android 자체보다는 AOSP만을 오픈 소스로 쳐주는 편이며 Google의 다른 제품으로 비교하면 Chrome과 Chromium의 관계와 비슷하다.

            그럼에도 불구하고 Android 기반 기기가 개발되는 이유는 위에서도 언급했다시피 Android가 단순 OS가 아니라 플랫폼이라는 지위를 갖고 있기 때문이다. 호환성, 확장성, 범용성 측면에서 매우 큰 이득이 있기 때문에 Google 서비스를 제외하더라도 그만한 가치가 있다.
            
            출처 : 나무위키
        """.trimIndent()
    )
}

@Preview
@Composable
private fun SamplePagePreview() {
    Surface {
        SamplePage()
    }
}