/**
 * 参数校验
 * 注解名	                说明
 * Email                                   被注解的元素必须是电子邮件地址。
 * Length(min,max)                         被注解的字符串大小必须在指定的范围内。
 * NotEmpty                                被注解的字符串必须非空。
 * Range(min,max)                          被注解的元素必须在合适的范围内。
 * NotBlank                                被注解的字符串必须非空。
 * URL(protocol,host,port,regexp,flags)    被注释的字符串必须是一个有效的URL。
 * CreditCardNumber                        被注释的字符串必须通过Luhn校验算法（银行卡、信用卡）。
 * ScriptAssert(lang,script,alias)         必须有JSR 223规范支持。
 * SafeHtml(whitelistType,additionalTags)  Class类类路径中有jsonup包。
 *
 * @author aries
 * @date 2022/8/25
 * @see <a href="https://github.com/silentbalanceyh/vertx-zero-example/blob/master/document/zero/005.validation.md">Vertx-Zero</a>
 */
package github.polarisink.basic.valid;